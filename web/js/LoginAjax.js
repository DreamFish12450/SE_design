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

                    let url2 = "http://localhost:8080/SE_design_Web_exploded/queryRole";
                    console.log(data["userId"]);
                    let name = data["userId"];
                    let data2 = {
                        name: name
                    };
                    $.ajax({
                        type: "get",
                        url: url2,
                        data: data2,
                        dataType: "json",
                        success: function(result){
                            //alert("success--result:"+result);
                            location.href="http://localhost:8080/SE_design_Web_exploded/home.jsp"
                        },
                        error: function(){
                            alert("error");
                        }

                    });



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
function countDown(secs,data){
    let url = "http://localhost:8080/SE_design_Web_exploded/queryRole";
    let name = data["userId"];
    let data2 = {
        name: name
    };
    $.ajax({
        type: "get",
        url: url,
        data: data,
        dataType: "json",
        success: function(result){
            alert("success--result:"+result);
        },
        error: function(){
            alert("error");
        }

    });

    if(--secs>0){
         setTimeout("countDown("+secs+")",1000);       
     }else{
         location.href="http://localhost:8080/SE_design_Web_exploded/home.jsp";
     }       
 }       

