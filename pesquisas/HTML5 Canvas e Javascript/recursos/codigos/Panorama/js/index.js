var img = new Image();

// User Variables - customize these to change the image being scrolled, its
// direction, and the speed.

img.src = 'https://mdn.mozillademos.org/files/4553/Capitan_Meadows,_Yosemite_National_Park.jpg';
var CanvasXSize = 800;
var CanvasYSize = 200;
var speed = 30; // lower is faster
var scale = 1.05;
var y = -4.5; // vertical offset

// Main program

var dx = 0.75;
var imgW;
var imgH;
var x = 0;
var clearX;
var clearY;
var ctx;

img.onload = function() {
    imgW = img.width * scale;
    imgH = img.height * scale;
    
    if (imgW > CanvasXSize) { x = CanvasXSize - imgW; } // image larger than canvas
    if (imgW > CanvasXSize) { clearX = imgW; } // image width larger than canvas
    else { clearX = CanvasXSize; }
    if (imgH > CanvasYSize) { clearY = imgH; } // image height larger than canvas
    else { clearY = CanvasYSize; }
    
    // get canvas context
    ctx = document.getElementById('canvas').getContext('2d');
 
    // set refresh rate
    return setInterval(draw, speed);
}

function draw() {
    ctx.clearRect(0, 0, clearX, clearY); // clear the canvas
    
    // if image is <= Canvas Size
    if (imgW <= CanvasXSize) {
        // reset, start from beginning
        if (x > CanvasXSize) { x = -imgW + x; }
        // draw additional image1
        if (x > 0) { ctx.drawImage(img, -imgW + x, y, imgW, imgH); }
        // draw additional image2
        if (x - imgW > 0) { ctx.drawImage(img, -imgW * 2 + x, y, imgW, imgH); }
    }

    // if image is > Canvas Size
    else {
        // reset, start from beginning
        if (x > (CanvasXSize)) { x = CanvasXSize - imgW; }
        // draw aditional image
        if (x > (CanvasXSize-imgW)) { ctx.drawImage(img, x - imgW + 1, y, imgW, imgH); }
    }
    // draw image
    ctx.drawImage(img, x, y,imgW, imgH);
    // amount to move
    x += dx;
}