function Facelogin() {
    setTimeout(function () {
        img = getFace();
        $.ajax({
            type:"post",
            url:"http://localhost:8080/SE_design_Web_exploded/user/login",//后台接口
            data:{
                "imgStr":img,
                "imgType":"BASE64"
            },
            dataType:"json",
            success:function (data) {
                console.log(data);
                var start = data["start"]
                if(start == true){
                    alert("用户id:"+data["userId"]+"登录"+data["msg"])
                    var secs=1;
                    countDown(secs)

                }
                else{
                	console.log(data["errorMsg"])
                    Facelogin();
                }
            },
            error:function () {
                alert("连接服务器失败")
            },
            async:true
        })
    },500);
}
function countDown(secs){    
         
     if(--secs>0){       
         setTimeout("countDown("+secs+")",1000);       
     }else{         
         location.href='indexc.jsp';
     }       
 }       

