function FaceRegister(path) {
    setTimeout(function () {

        let index = window.location.href .lastIndexOf("\/")
        var str  =  window.location.href .substring(0,index)
        img = getFace();
        $.ajax({
            type:"post",
            url:`${str}/register`,//后台接口
            data:{
            	"imgId":$("#imgId").val(),
                "imgStr":img,
                "imgType":"BASE64"
            },
            dataType:"json",
            success:function (data) {
                console.log(data);
                var start = data["start"]
                if(start == true){
                	alert(data["msg"])
                    var secs=1;
                    countDown(secs)
                }
                else{
                	alert(data["errorMsg"])
                    Facelogin();
                }
            },
            error:function () {
                // alert("连接服务器失败")
            },
            async:true
        })
    },1000);
}
function countDown(secs){

    if(--secs>0){
        setTimeout("countDown("+secs+")",1000);
    }else{
        location.href='/inite.jsp';
    }
}
