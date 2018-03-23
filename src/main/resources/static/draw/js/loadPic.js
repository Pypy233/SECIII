
/*
var imgUrl = new Array();
//   var imgLink=new Array();
//   var imgtext=new Array();
var adNum=0;

imgUrl[1] = "images/cat.png";
imgUrl[2] = "images/chairs.png";
imgUrl[3] = "images/city.png";

function previousPic(){
    //添加更换背景图片的方法-前翻
    initCanvas();
    adNum--;
    var img = new Image();
    if(adNum < 1){
        adNum = 3;
    }
    img.src = imgUrl[adNum];
    img.onload = function(){
        context.drawImage(img , 0 ,0 , img.width , img.height , 0 ,0 , canvasWidth , canvasHeight);
    }
}

function nextPic(){
    //添加更换背景图片的方法-后翻
    initCanvas();
    adNum++;
    var img = new Image();
    if(adNum > 3){
        adNum = 1;
    }
    img.src = imgUrl[adNum];

    // $("#canvas").style.backgroundImage="url(img.src)";

    img.onload = function(){
        context.drawImage(img , 0 ,0 , img.width , img.height , 0 ,0 , canvasWidth , canvasHeight);
    }

}

var initCanvas = function(){
    canvas =  document.getElementById("canvas");
    canvas.width = canvasWidth;
    canvas.height = canvasHeight;
    context = canvas.getContext('2d');

    canvasTop = $(canvas).offset().top;
    canvasLeft = $(canvas).offset().left;

    canvas_bak =  document.getElementById("canvas_bak");
    canvas_bak.width = canvasWidth;
    canvas_bak.height = canvasHeight;
    context_bak = canvas_bak.getContext('2d');

    //初始化时加载图片

}


*/