//画布
var canvas;
var context;
var canvas_bak;
var context_bak;
var canvasWidth = 960;
var canvasHeight = 580;
var canvasTop;
var canvasLeft;

//画笔大小
var size = 1;
var color  = '#000000';


var tagList = [];


var startX;
var startY;

var endX;
var endY;

var x;
var y;

//是否有框被选中
var isSelected = false;

//被选中的框图值
var focX1, focY1, focX2, focY2;

//被双击的标签索引
var tagFlag;


function saveTagForWhole(imageID, description){
    $.ajax({
        type:"POST",
        url:"/workplace/whole/save",
        dataType:"json",
        data:{
            imageID : imageID,
            description : description
        },

        success : function (data) {
            if(data.success){
                alert("Success saved for whole picture !");
            }
            else
                alert("Error for whole picture !");
        },

        error : function () {
            alert("Network warning for saving whole picture !");
        }

    });
}

//删除整张照片的标签
function deleteTagForWhole(imageID){

    $.ajax({
        type:"POST",
        url:"/workplace/whole/delete",
        dataType:"json",
        data:{
            imageID : imageID
        },

        success : function (data) {
            if(data.success){
                alert("Success deleted for whole picture !");
            }
            else
                alert("Error deleted for whole picture !");
        },

        error : function () {
            alert("Network warning for deleting whole picture !");
        }

    });
}

//更改整张照片的标签
function updateTagForWhole(imageID, description){
    $.ajax({
        type:"POST",
        url:"/workplace/whole/update",
        dataType:"json",
        data:{
            imageID : imageID,
            description : description
        },

        success : function (data) {
            if(data.success){
                alert("Success updated for whole picture !");
            }
            else
                alert("Error updated for whole picture !");
        },

        error : function () {
            alert("Network warning for updating whole picture !");
        }

    });
}



//保存部分照片的标签
function saveTagForPart(imageID, x1, x2, y1, y2, description){
    $.ajax({
        type:"POST",
        url:"/workplace/part/save",
        dataType:"json",
        data:{
            imageID : imageID,
            x1: x1,
            x2: x2,
            y1: y1,
            y2: y2,
            description : description
        },

        success : function (data) {
            if(data.success){
                alert("Success saved for part picture !");
            }
            else
                alert("Error savedd for part picture !");
        },

        error : function () {
            alert("Network warning for saving part picture !");
        }

    });
}

//删除部分照片的标签
function deleteTagForPart(imageID){
    $.ajax({
        type:"POST",
        url:"/workplace/part/delete",
        dataType:"json",
        data:{
            imageID : imageID
        },

        success : function (data) {
            if(data.success){
                alert("Success deleted for part picture !");
            }
            else
                alert("Error deleted for part picture !");
        },

        error : function () {
            alert("Network warning for deleting part picture !");
        }

    });
}

//更新部分照片的标签
function updateTagForPart(imageID, x1, x2, y1, y2, description){
    $.ajax({
        type:"POST",
        url:"/workplace/part/update",
        dataType:"json",
        data:{
            imageID : imageID,
            x1: x1,
            x2: x2,
            y1: y1,
            y2: y2,
            description : description
        },

        success : function (data) {
            if(data.success){
                alert("Success updated for part picture !");
            }
            else
                alert("Error updated for part picture !");
        },

        error : function () {
            alert("Network warning for updating part picture !");
        }

    });
}




//画图形
var draw_graph = function(graphType,obj){

	//把背景图片的蒙版放在画板上
	//$("#canvas_pic").css("z-index",1);

	//把蒙版放于画板上面
	$("#canvas_bak").css("z-index",2);
	//先画在蒙版上 再复制到画布上

	chooseImg(obj);
	var canDraw = false;

	//鼠标按下获取 开始xy开始画图
	var mousedown = function(e){
	    isSelected = false;
		scroolTop = $(window).scrollTop();
		scroolLeft = $(window).scrollLeft();
		canvasTop = $(canvas).offset().top - scroolTop;
		canvasLeft = $(canvas).offset().left - scroolLeft;

		context.strokeStyle= color;
		context_bak.strokeStyle= color;
		context_bak.lineWidth = size;

		startX = e.clientX - canvasLeft;
		startY = e.clientY - canvasTop;
		context_bak.moveTo(startX ,startY );
		canDraw = true;

		if(graphType == 'pencil'){
			context_bak.beginPath();
		}else if(graphType == 'circle'){
			context.beginPath();
			context.moveTo(startX ,startY );
			context.lineTo(startX +1 ,startY+1);
			context.stroke();

		}else if(graphType == 'rubber'){
			context.clearRect(startX - size * 10 ,  startY - size * 10 , size * 20 , size * 20);
		}
		// 阻止点击时的cursor的变化，draw
		e=e||window.event;
		e.preventDefault();
	};

	//鼠标离开 把蒙版canvas的图片生成到canvas中
	var mouseup = function(e){
		e=e||window.event;
		canDraw = false;
		var image = new Image();
		if(graphType!='rubber'){
			image.src = canvas_bak.toDataURL();
			image.onload = function(){
				context.drawImage(image , 0 ,0 , image.width , image.height , 0 ,0 , canvasWidth , canvasHeight);
				clearContext();
				saveImageToAry();
			}
			endX = x;
			endY = y;
			// 遗留的小尾巴
			// var x = e.clientX   - canvasLeft;
			// var y = e.clientY  - canvasTop;
			// context.beginPath();
			// context.moveTo(x ,y );
			// context.lineTo(x +2 ,y+2);
			// context.stroke();

		}
	};

	//选择功能按钮 修改样式
	function chooseImg(obj){
		var imgAry  = $(".draw_controller li");
		for(var i=0;i<imgAry.length;i++){
			$(imgAry[i]).removeClass('active');
			$(imgAry[i]).addClass('normal');
		}
		$(obj).removeClass("normal");
		$(obj).addClass("active");
	}

	// 鼠标移动
	var  mousemove = function(e){
		scroolTop = $(window).scrollTop();
		scroolLeft = $(window).scrollLeft();
		canvasTop = $(canvas).offset().top - scroolTop;
		canvasLeft = $(canvas).offset().left - scroolLeft;
		e=e||window.event;
		x = e.clientX   - canvasLeft;
		y = e.clientY  - canvasTop;
		//方块  4条直线搞定
		if(graphType == 'square'){
			if(canDraw){
				context_bak.beginPath();
				clearContext();
				context_bak.moveTo(startX , startY);
				context_bak.lineTo(x  ,startY );
				context_bak.lineTo(x  ,y );
				context_bak.lineTo(startX  ,y );
				context_bak.lineTo(startX  ,startY );
				context_bak.stroke();
			}
		//直线
		}else if(graphType =='line'){
			if(canDraw){
				context_bak.beginPath();
				clearContext();
				context_bak.moveTo(startX , startY);
				context_bak.lineTo(x  ,y );
				context_bak.stroke();
			}
		//画笔
		}else if(graphType == 'pencil'){
			if(canDraw){
				context_bak.lineTo(e.clientX   - canvasLeft ,e.clientY  - canvasTop);
				context_bak.stroke();
			}
		//圆 未画得时候 出现一个小圆
		}else if(graphType == 'circle'){
			clearContext();
			if(canDraw){
				// 鼠标点击移动时产生的圆
				context_bak.beginPath();
				var radii = Math.sqrt((startX - x) *  (startX - x)  + (startY - y) * (startY - y));
				context_bak.arc(startX,startY,radii,0,Math.PI * 2,false);
				context_bak.stroke();
			}else{
				context_bak.beginPath();
				context_bak.arc(x,y,20,0,Math.PI * 2,false);
				context_bak.stroke();
			}
		//涂鸦 未画得时候 出现一个小圆
		}else if(graphType == 'handwriting'){
			if(canDraw){
				// 鼠标点击移动产生的圆圈
				context_bak.beginPath();
				context_bak.strokeStyle = color;
				context_bak.fillStyle = color;

				//计算当前点和上一个点的距离
				var tmpX = x - startX;
				var tmpY = y - startY;
				var dist = Math.sqrt(Math.pow(tmpX, 2) + Math.pow(tmpY, 2));
				dist = Math.round(dist);

				//定义递增点
				var ix = tmpX / dist;
				var iy = tmpY / dist;

				//定义绘制点
				var currX = startX;
				var currY = startY;
				for(var i = 0; i < dist; i++) {
					context_bak.arc(currX, currY, size * 10, 0, Math.PI * 2, false);

					currX += ix;
					currY += iy;
				}

				context_bak.fill();
				context_bak.stroke();
				context_bak.restore();

				//保存上一次的点
				startX = x;
				startY = y;
			}else{
				clearContext();
				context_bak.beginPath();
				context_bak.strokeStyle = color;
				context_bak.fillStyle  = color;
				context_bak.arc(x,y,size*10,0,Math.PI * 2,false);
				context_bak.fill();
				context_bak.stroke();
			}
		//橡皮擦 不管有没有在画都出现小方块 按下鼠标 开始清空区域
		}else if(graphType == 'rubber'){
			context_bak.lineWidth = 1;
			clearContext();
			context_bak.beginPath();
			context_bak.strokeStyle =  '#000000';
			context_bak.moveTo(x - size * 10 ,  y - size * 10 );
			context_bak.lineTo(x + size * 10  , y - size * 10 );
			context_bak.lineTo(x + size * 10  , y + size * 10 );
			context_bak.lineTo(x - size * 10  , y + size * 10 );
			context_bak.lineTo(x - size * 10  , y - size * 10 );
			context_bak.stroke();
			if(canDraw){
				context.clearRect(x - size * 10 ,  y - size * 10 , size * 20 , size * 20);

			}
		}
	};


	//鼠标离开区域以外 除了涂鸦 都清空
	var mouseout = function(){
		if(graphType != 'handwriting'){
			clearContext();
		}
	}

     var dblclick = function (e) {

        isSelected = true;

        var clickX = e.clientX - canvasLeft;
        var clickY = e.clientY - canvasTop;

        console.log('doubleclick')

        for (var i = 0; i < tagList.length; i++) {
            if ((clickX >= tagList[i].x1 && clickY >= tagList[i].y1
                    && clickX <= tagList[i].x2 && clickY <= tagList[i].y2)
                || (clickX >= tagList[i].x1 && clickY <= tagList[i].y1
                    && clickX <= tagList[i].x2 && clickY >= tagList[i].y2)
                || (clickX <= tagList[i].x1 && clickY >= tagList[i].y1
                    && clickX >= tagList[i].x2 && clickY <= tagList[i].y2)
                || (clickX <= tagList[i].x1 && clickY <= tagList[i].y1
                    && clickX >= tagList[i].x2 && clickY >= tagList[i].y2)) {
                focX1 = tagList[i].x1;
                focY1 = tagList[i].y1;
                focX2 = tagList[i].x2;
                focY2 = tagList[i].y2;
                tagFlag = i;
                break;
            }
            else if(i == tagList.length-1)
                isSelected = false;
        }
    }

	$(canvas_bak).unbind();
	$(canvas_bak).bind('mousedown',mousedown);
	$(canvas_bak).bind('mousemove',mousemove);
	$(canvas_bak).bind('mouseup',mouseup);
	$(canvas_bak).bind('mouseout',mouseout);
	$(canvas_bak).bind('dblclick',dblclick);
}

var draw_tag = function () {
    // labelList[selected].tag = tag;
    // $('#label_').find('.tag-list').eq(0).html(drawTag(tag));

        var tagX;
        var tagY;

        // console.log(imgsrc);
        // imgsrc = imgsrc.substring(imgsrc.search("draw/images/")+12);
        // console.log(imgsrc);
        var s= imgsrc.search("draw/images/");
        // console.log(imgsrc.substring(s+12));
        var e= imgsrc.search(".png");
        var imageID = imgsrc.substring(s+12,e);
        // console.log(imageID);
        if (isSelected) {
            tagX = focX1 < focX2 ? focX1 : focX2;
            tagY = focY1 < focY2 ? focY1 : focY2;

            var lengthOfRect = tagList[tagFlag].words.length;
            context.clearRect(tagX+1,tagY+1,12*lengthOfRect,20);
          //  context_bak.clearRect(tagX,tagY,100,100)
            //注意需从数据中获取数据得到字符串长度来清除
            var tag = {
                x1:focX1,
                y1:focY1,
                x2:focX2,
                y2:focY2,
                words:$('#label-tag').val()
                }
            tagList[tagFlag] = tag;
            updateTagForPart(imageID,focX1,focX2,focY1,focY2,$('#label-tag').val());
        }
        else {
            tagX = startX < endX ? startX : endX;
            tagY = startY < endY ? startY : endY;

            var tag = {
                x1:startX,
                y1:startY,
                x2:endX,
                y2:endY,
                words:$('#label-tag').val()
            }

            tagList.push(tag);
            saveTagForPart(imageID, startX, endX, startY, endY, $('#label-tag').val());
        }

    context.fillStyle = "black";
    context.font = "20px Verdana";
    context.textAlign = "left";
    context.fillText($('#label-tag').val(),tagX,tagY+17);




};




//清空层
var clearContext = function(type){
	if(!type){
		context_bak.clearRect(0,0,canvasWidth,canvasHeight);
	}else{
	    var img = new Image();
	    img.src = imgsrc;
	    img.onload = function(){
            context.drawImage(img , 0 ,0 , img.width , img.height , 0 ,0 , canvasWidth , canvasHeight);

        }
		//context.clearRect(0,0,canvasWidth,canvasHeight);
		context_bak.clearRect(0,0,canvasWidth,canvasHeight);
	}
}



var imgUrl = new Array();
var adNum=0;
var imgsrc = "draw/images/background.png";
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
    imgsrc = img.src;
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
    imgsrc = img.src;
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
