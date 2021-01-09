function Facelogin() {
    setTimeout(function () {

        let index = window.location.href .lastIndexOf("\/")
        window.str  =  window.location.href .substring(0,index)
        console.log(str)
        img = getFace();
        $.ajax({
            type:"post",
            url:`${str}/user/login`,//后台接口
            data:{
                "imgStr":img,
                "imgType":"BASE64"
            },
            dataType:"json",
            success:function (data) {
                console.log(data);
                var start = data["start"]
                if(start === true){
                    // alert("用户id:"+data["userId"]+"登录"+data["msg"])
                    var secs=1;
                    countDown(secs)

                }
                else{
                	console.log(data["errorMsg"])
                    Facelogin();
                }
            },
            error:function () {
                // alert("连接服务器失败")
            },
            async:true
        })
    },500);
}
function countDown(secs){    
         
     if(--secs>0){       
         setTimeout("countDown("+secs+")",1000);       
     }else{
         location.href=` ${window.str}/home.jsp;`
     }       
 }       

