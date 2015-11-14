package info.novatec.inspectit.rcp.wizard;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import info.novatec.inspectit.communication.data.cmr.User;
import info.novatec.inspectit.exception.RemoteException;
import info.novatec.inspectit.rcp.repository.CmrRepositoryDefinition;
import info.novatec.inspectit.rcp.wizard.page.CmrLoginWizardPage;

/**
 * Wizard for logging into a CMR.
 * 
 * @author Clemens Geibel
 * @author Andreas Herzog
 */

public class CmrLoginWizard extends Wizard implements INewWizard {

	/**
	 * test.
	 */
	private CmrRepositoryDefinition cmrRepositoryDefinition;

	/**
	 * {@link CmrLoginWizardPage}.
	 */
	private CmrLoginWizardPage cmrLoginWizardPage;

	/**
	 * Default constructor.
	 * @param cmrRepositoryDefinition .
	 */
	public CmrLoginWizard(CmrRepositoryDefinition cmrRepositoryDefinition) {
		this.setWindowTitle("CMR Login");
		this.cmrRepositoryDefinition = cmrRepositoryDefinition;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		cmrLoginWizardPage = new CmrLoginWizardPage("CMR Login");
		addPage(cmrLoginWizardPage);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}

	/**
	 * {@inheritDoc} This method needs to be edited as soon as it is possible to connect to the CMR
	 * database.
	 */
	@Override
	public boolean performFinish() {
		try {
			User authRequest = cmrRepositoryDefinition
					.getSecurityService()
					.authenticate(cmrLoginWizardPage.getPasswordBox().getText(), cmrLoginWizardPage.getMailBox().getText());
			MessageDialog.openInformation(null, "Successfully authenticated at selected CMR", authRequest.toString());
		} catch (RemoteException re) {
			MessageDialog.openError(null, "Login failed", "E-Mail or Password is incorrect!");
		}
		return false;
	}

}
