package view;

import data.user.Administrator;

/*import client.AdministratorIndividualPanel;
import client.LoginPanel;
import client.MainFrame;*/

public class AdministratorLoginPanel extends LoginPanel{
	/**�����ǹ���Ա�ĵ�¼���棬�̳е�¼���棬ʵ���˴��븴��
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdministratorLoginPanel(MainFrame mFrame) {
		super(mFrame);
	}
	
	//�����˸�����Ӧ�ķ�����ʵ��ҳ����ת
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