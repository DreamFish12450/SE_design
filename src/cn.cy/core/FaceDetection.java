package cn.cy.core;

import java.util.HashMap;

import cn.cy.domain.Image;
import org.json.JSONObject;

import com.baidu.aip.face.AipFace;

public class FaceDetection {

	public String Facedetection(AipFace client, Image image){
		HashMap<String, String> options= new HashMap<String, String>();
		options.put("face_field", "age");
		options.put("max_face_num", "1");
		options.put("face_type", "LIVE");
		JSONObject res=client.detect(image.getImgStr(), image.getImgType(), options);
		return res.toString(2);
	}

	
}
