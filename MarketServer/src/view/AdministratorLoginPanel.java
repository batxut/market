package view;

import data.user.Administrator;

/*import client.AdministratorIndividualPanel;
import client.LoginPanel;
import client.MainFrame;*/

public class AdministratorLoginPanel extends LoginPanel{
	/**该类是管理员的登录界面，继承登录界面，实现了代码复用
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdministratorLoginPanel(MainFrame mFrame) {
		super(mFrame);
	}
	
	//覆盖了父类相应的方法，实现页面跳转
	void checkInfo(){
	/*	if(admin.getID().equals(name)&&admin.getPassword().equals(password)){
			isLoginSucessful=true;
			relatedConduct();
		}*/
		if(ID.equals("admin")&&password.equals("admin"))
		{
			admin=new Administrator("admin","admin","admin");
			isLoginSucessful=true;
			relatedConduct();
		}
	}
	void loadIndividualPanel(){
		super.loadIndividualPanel();
		AdministratorIndividualPanel adminPanel=new AdministratorIndividualPanel(admin);
		this.add(adminPanel);
		adminPanel.showPanel();
	}
}