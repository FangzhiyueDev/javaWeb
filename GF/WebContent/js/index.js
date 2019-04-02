/**

 我门使用jquery来实现
 */

$(document).ready(function () {


    //播放视频放大
    //  videoBig();

    //获得后端视频数据
    // getData();

    //点击的操作
    product();

    playMusic();

});

var videoBig = function () {
    $(".product-one:first-child").mouseover(function () {

        //     $(this).css({
        //         "width": "56%"
        //     })
        //
        //     $(this).next().css({
        //         "width": "43%"
        //     })
        //
        // }).mouseout(function () {
        //     $(this).css({
        //         "width": "49%"
        //     })
        //     $(this).next().css({
        //         "width": "49%"
        //     })


    })


    $(".product-one:last-child").mouseover(function () {

        //     $(this).css({
        //         "width": "56%"
        //     })
        //
        //     $(this).prev().css({
        //         "width": "43%"
        //     })
        //
        // }).mouseout(function () {
        //     $(this).css({
        //         "width": "49%"
        //     })
        //     $(this).prev().css({
        //         "width": "49%"
        //     })
        // })
    })
}


var data = {

    "allData": ["images/1.jpg", "images/2.jpg", "images/3.jpg", "images/4.jpg", "images/5.jpg", "images/6.jpg", "images/7.jpg", "images/8.jpg", "images/9.jpg",
        "images/10.jpg", "images/11.jpg", "images/12.jpg", "images/13.mp4"
    ],
    "lift": [
        "images/1.jpg", "images/2.jpg", "images/3.jpg", "images/5.jpg", "images/6.jpg", "images/8.jpg", "images/9.jpg",
        "images/10.jpg", "images/12.jpg"
    ],
    "fengjing": [
        "images/4.jpg", "images/7.jpg", "images/11.jpg"
    ],
    "weishiping": [
        "images/13.mp4"
    ]
}

var product = function () {


    var box = $(".gf-product-dis-list")

    var html = "";

    defaultIndex = 0;


    box.html("")
    html = ""
    for (var i = 0; i < data.allData.length; i += 2) {
        html += "  <div class=\"product-box\">\n" +
            "            <div class=\"product-one f_left\">\n" +
            "                <img src=\"" + data.allData[i] + "\" alt=\"\">\n" +
            "            </div>\n" +
            "            <div class=\"product-one f_right\">\n" +
            "                <img src=\"" + data.allData[i + 1] + "\" alt=\"\">\n" +
            "            </div>\n" +
            "        </div>\n";
    }

    box.html(html);


    $(".bt-product").click(function () {

            $(".bt-product").removeClass("active")

            var text = $(this).text();

            $(this).addClass("active")


            box.html("")
            html = ""

            if (text == "全部作品") {


                for (var i = 0; i < data.allData.length; i += 2) {
                    html += "  <div class=\"product-box\">\n" +
                        "            <div class=\"product-one f_left\">\n" +
                        "                <img src=\"" + data.allData[i] + "\" alt=\"\">\n" +
                        "            </div>\n" +
                        "            <div class=\"product-one f_right\">\n" +
                        "                <img src=\"" + data.allData[i + 1] + "\" alt=\"\">\n" +
                        "            </div>\n" +
                        "        </div>\n";
                }

                console.log(html)


            } else if (text == "微视频") {

                for (var i = 0; i < data.weishiping.length; i += 2) {
                    html += "  <div class=\"product-box\">\n" +
                        "            <div class=\"product-one f_left\">\n" +
                        "                <video src=\"" + data.weishiping[i] + "\" alt=\"\" autoplay>\n" +
                        "            </div>\n" +
                        "            <div class=\"product-one f_right\">\n" +
                        "                <video src=\"" + data.weishiping[i + 1] + "\" alt=\"\" autoplay>\n" +
                        "            </div>\n" +
                        "        </div>\n";
                }


            } else if (text == "风景照") {

                for (var i = 0; i < data.fengjing.length; i += 2) {
                    html += "  <div class=\"product-box\">\n" +
                        "            <div class=\"product-one f_left\">\n" +
                        "                <img src=\"" + data.fengjing[i] + "\" alt=\"\">\n" +
                        "            </div>\n" +
                        "            <div class=\"product-one f_right\">\n" +
                        "                <img src=\"" + data.fengjing[i + 1] + "\" alt=\"\">\n" +
                        "            </div>\n" +
                        "        </div>\n";
                }
            }
            else if (text == "生活照") {

                for (var i = 0; i < data.lift.length; i += 2) {
                    html += "  <div class=\"product-box\">\n" +
                        "            <div class=\"product-one f_left\">\n" +
                        "                <img src=\"" + data.lift[i] + "\" alt=\"\">\n" +
                        "            </div>\n" +
                        "            <div class=\"product-one f_right\">\n" +
                        "                <img src=\"" + data.lift[i + 1] + "\" alt=\"\">\n" +
                        "            </div>\n" +
                        "        </div>\n";
                }
            }

            box.html(html);
        }
    );
}


var playMusic = function () {

}

