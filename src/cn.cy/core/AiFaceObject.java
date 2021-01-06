package cn.cy.core;

import com.baidu.aip.face.AipFace;

public class AiFaceObject {
	    public String APP_ID = "22964796";//�ٶ�web_face
	    public String API_KEY = "Ga6Y73tKGCgUbOIMkZEbuQRU";
	    public String SECRET_KEY = "yKpjLhoHy0FZf2x0meoBsgqPdqK5BQPv";
	    public String GROUD_LIST = "czy_face";
	    
	    private AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

	    public AipFace getClient(){
	    	client.setConnectionTimeoutInMillis(2000);
	    	client.setSocketTimeoutInMillis(60000);
	    	return client;
	    }
	    
}
