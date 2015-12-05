package info.novatec.inspectit.rcp.wizard.page;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import info.novatec.inspectit.rcp.dialog.ShowAllRolesDialog;
import info.novatec.inspectit.rcp.dialog.ShowAllUsersDialog;
import info.novatec.inspectit.rcp.dialog.AddRoleDialog;
import info.novatec.inspectit.rcp.dialog.AddUserDialog;
import info.novatec.inspectit.rcp.dialog.SearchPermissionsDialog;
import info.novatec.inspectit.rcp.dialog.SearchRolesDialog;
import info.novatec.inspectit.rcp.dialog.SearchUsersDialog;
import info.novatec.inspectit.rcp.dialog.ShowAllPermissionsDialog;

/**
 * Wizard Page for managing users on the CMR.
 * 
 * @author Lucca Hellriegel
 *
 */
public class CmrAdministrationWizardPage extends WizardPage {
	/**
	 * Default page message.
	 */
	private static final String DEFAULT_MESSAGE = "Managing users and roles.";

	/**
	 * Default constructor.
	 * 
	 * @param title
	 *            title for the CMR Administration Page
	 */
	public CmrAdministrationWizardPage(String title) {
		super(title);
		this.setTitle(title);
		this.setMessage(DEFAULT_MESSAGE);
	}

	/**
	 * The dialog to show available permissions.
	 */
	private ShowAllPermissionsDialog showAllPermissionsDialog;

	/**
	 * The dialog to show available roles.
	 */
	private ShowAllRolesDialog showAllRolesDialog;

	/**
	 * The dialog to show available users.
	 */
	private ShowAllUsersDialog showAllUsersDialog;
	
	/**
	 * The dialog to search available permissions.
	 */
	private SearchPermissionsDialog searchPermissionsDialog;

	/**
	 * The dialog to search available roles.
	 */
	private SearchRolesDialog searchRolesDialog;

	/**
	 * The dialog to search available users.
	 */
	private SearchUsersDialog searchUsersDialog;
	
	/**
	 * The dialog to search available roles.
	 */
	private AddRoleDialog addRoleDialog;

	/**
	 * The dialog to search available users.
	 */
	private AddUserDialog addUserDialog;
	
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createControl(Composite parent) {
		final Composite main = new Composite(parent, SWT.NONE);
		main.setLayout(new GridLayout(3, false));

		Button showUsers = new Button(main, SWT.CENTER);
		showUsers.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		showUsers.setText("Show All Users");
		showUsers.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				showAllUsersDialog = new ShowAllUsersDialog(main.getShell());
				showAllUsersDialog.open();
			}
		});
				
		Button searchUsers = new Button(main, SWT.CENTER);
		searchUsers.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		searchUsers.setText("Search All Users");
		searchUsers.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				searchUsersDialog = new SearchUsersDialog(main.getShell());
				searchUsersDialog.open();
			}
		});
		
		Button adduser = new Button(main, SWT.CENTER);
		adduser.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		adduser.setText("Add User");
		adduser.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addUserDialog = new AddUserDialog(main.getShell());
				addUserDialog.open();
			}
		});
		
		Button showRoles = new Button(main, SWT.CENTER);
		showRoles.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		showRoles.setText("Show All Roles");
		showRoles.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				showAllRolesDialog = new ShowAllRolesDialog(main.getShell());
				showAllRolesDialog.open();
			}
		});
		
		Button searchRoles = new Button(main, SWT.CENTER);
		searchRoles.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		searchRoles.setText("Search All Roles");
		searchRoles.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				searchRolesDialog = new SearchRolesDialog(main.getShell());
				searchRolesDialog.open();
			}
		});
		
		Button addRole = new Button(main, SWT.CENTER);
		addRole.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		addRole.setText("Add Role");
		addRole.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addRoleDialog = new AddRoleDialog(main.getShell());
				addRoleDialog.open();
			}
		});
				
		Button showPermissions = new Button(main, SWT.CENTER);
		showPermissions.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		showPermissions.setText("Show All Permissions");
		showPermissions.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				showAllPermissionsDialog = new ShowAllPermissionsDialog(main.getShell());
				showAllPermissionsDialog.open();
			}
		});
						
		Button searchPermissions = new Button(main, SWT.CENTER);
		searchPermissions.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		searchPermissions.setText("Search All Permissions");
		searchPermissions.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				searchPermissionsDialog = new SearchPermissionsDialog(main.getShell());
				searchPermissionsDialog.open();
			}
		});
		
		
		
		

		setControl(main);
	}
	
}
