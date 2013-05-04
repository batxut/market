package view;

import logic.SearchUserController;
import server_interface.SearchUser;
import data.user.GeneralManager;


public class GManagerLoginPanel extends LoginPanel
{
	
	private static final long serialVersionUID = 1L;
	
	private GeneralManager gm;
	private SearchUser inter2;
	public GManagerLoginPanel(MainFrame mFrame){
		super(mFrame);
		inter2=new SearchUserController();
	}
	
	//覆盖了父类相应的方法，实现页面跳转
	void checkInfo(){
		/*
		if(name.equals("g")&&password.equals("g"))
		{
			isLoginSucessful=true;
			gm=new GeneralManager("gmanager","gmanager","gmanager");
			relatedConduct();
		}
		*/
		gm=inter2.searchGM(ID, password);
		if(gm!=null)
		{
			isLoginSucessful=true;
			relatedConduct();
		}
	}
	
	void loadIndividualPanel(){
		super.loadIndividualPanel();
		GManagerIndividualPanel stuPanel=new GManagerIndividualPanel(gm);
		this.add(stuPanel);
		stuPanel.showPanel();
	}
}
