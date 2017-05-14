//javascript
var ADDCASE = ADDCASE || {};
var PROJECT = PROJECT || {};
var GROUP = GROUP || {};
var TIMETOOL = TIMETOOL || {};
var APIPATH = APIPATH || {};

var hostSite = 'http://127.0.0.1';
var serverPort = 8080;

//////////////////////////////////////////




ADDCASE.setMethod1 = function(id, v) {

    //alert($("#"+id).length);
    $("#" + id).each(function() {
        //alert($(this).text())
        $(this).attr('class', '');
        //$(this).removeClass("active");
    });
    //	$(id).each(function(){
    //    		alert($(this).text());
    //			alert($(this).attr("class"));
    //		});

    $(this).attr('class', 'active');
    alert($(this).attr('class'));
    alert($(this).tagName);
}


ADDCASE.setMethod2 = function(id) {
    var list = $("#" + id);
    for (var i = 0; i < list.length; i++) {

        list.attr('class', '');
        list[i].onclick = function() {
            alert($(this).text);
            $(this).attr('class', 'active');
        }
        debugger;
    }

}

ADDCASE.setMethod = function(e_id, event) {
    $(this).delegate("li", "click", function() {
        // "$(this)" is the node that was clicked
        //alert("you clicked a link!", $(this));
        alert($(this).text);
    });
}

/*ADDCASE.onclick = function (id) {
 　　var oUl = $("#" + id + " li");
 　　oUl.onclick = function (ev) {
 　　　　var ev = ev || window.event;
 　　　　var target = ev.target || ev.srcElement;
 　　　　if (target.nodeName.toLowerCase() == 'li') {
 alert(123);
 alert(target.innerHTML);
 　　　　}
 　　}
 }
 */


ADDCASE.changeMethod = function(id) {
    $(id)[0].onclick = function(e) {
        if (e.target && e.target.nodeName.toUpperCase() === 'A') {
            var elems = $(id + '>li');
            elems.map(function(index, value) {
                $(value).removeClass('active');
            });
            $(e.target).parent().attr('class', 'active');
        }
    }
}
ADDCASE.changeMethodButtonToPrimary = function(id) {
    $(id).onclick = function(e) {
        if (e.target && e.target.nodeName.toUpperCase() === 'INPUT') {
            var elems = $(id + '>label');
            elems.map(function(index, value) {
                $(value).removeClass('active', 'btn btn-default');
            });
            debugger;
            $(e.target).parent().attr('class', 'btn btn-primary active');
        }
    }
}

ADDCASE.changeTestModelDisplay = function(id) {
    $(id).attr('style', '');
}

ADDCASE.changeTestModelHidden = function(id) {
    $(id).attr('style', 'display:none');
}

ADDCASE.changeTestModelHidden_duo = function() {

    $('#CheckKey').attr('style', 'display:none');
    $('#selectCheckType').attr('style', 'display:none');
    $('#CheckErrorMassage').attr('style', 'display:none');
    $('#CheckCode').attr('style', 'display:none');


}

ADDCASE.changeTestModelDisplay_duo = function() {

    $('#CheckKey').attr('style', '');
    $('#selectCheckType').attr('style', '');
    $('#CheckErrorMassage').attr('style', '');
    $('#CheckCode').attr('style', '');


}

ADDCASE.setInputApi = function(id_1, id_2) {

    $(id_1).attr('style', '');
    $(id_2).attr('style', 'display:none');
}



/**
 * ===========================================================================
 * 项目相关js
 */

PROJECT.showByPath = function(ids) {

    var id = ids.split(",");
    for (var i = 0; i < id.length; i++) {
        $(id[i]).attr('style', '');

    }
    /**
     $(id1).attr('style', '');
     $(id2).attr('style', '');
     $(id3).attr('style', '');
     */
}

PROJECT.hiddenByPath = function(ids) {
    var id = ids.split(",");
    for (var i = 0; i < id.length; i++) {
        $(id[i]).attr('style', 'display:none');
    }

}



PROJECT.getProjectListByAjax = function(tableBody, tableValue) {



    $.ajax({
        url: hostSite + ":" + serverPort + "/project", //请求的URL
        timeout: 500, //超时时间设置，单位毫秒
        type: 'get', //请求方式，get或post
        data: {}, //请求所传参数，json格式
        dataType: 'json', //返回的数据格式
        success: function(data) { //请求成功的回调函数


            PROJECT.drewTables(data, tableBody, tableValue);
        },
        complete: function(XMLHttpRequest, status) { //请求完成后最终执行参数

            if (status == 'timeout') { //超时,status还有success,error等值的情况

                ajaxTimeoutTest.abort();
                alert("超时");
                $(tableBody).html(' <div style="text-align:center;font-size:22px;"> <p></p><span class="glyphicon glyphicon-glass"><label><b> 连接超时，刷新试试！</b></lable></span><p></p></div>');
            } else if (XMLHttpRequest.status == 500) {
                $(tableBody).html(' <div style="text-align:center;font-size:22px;"> <p></p><span class="glyphicon glyphicon-warning-sign"><label><b> 服务器异常！</b></lable></span><p></p></div>');
            }
        }
    });

}

PROJECT.getProjectList = function() {
    $.get(hostSite + ":" + serverPort + "/project", {}, function(data) {
        PROJECT.drewTables(data);

    });

}


PROJECT.drewTables = function(data, tableBody, tableValue) {

    //var data = null;
    //data_list = JSON.parse(data);
    var table_code = '';

    if (data.length == 0) {
        var table_null = ' <div style="text-align:center;font-size:22px;"> <p></p><span class="glyphicon glyphicon-glass"><label><b> 还没有项目，快去建立吧！</b></lable></span><p></p></div>';

        $(tableBody).html(table_null);
    } else {
        $.each(data, function(key, val) {

            table_code = table_code +
                '<tr><td>' + this.title + '</td>' +
                '<td>' + this.comment + '</td>' +
                '<td>' + TIMETOOL.changeYYMMDD(this.createTime, true, 8) + '</td>' +
                '<td>' + TIMETOOL.changeYYMMDD(this.updateTime) + '</td>' +
                '<td>' +
                '<td><a href="#"><span class="glyphicon glyphicon-pencil">查看</span></a>' +
                ' <a href="#"><span class="glyphicon glyphicon-pencil">修改</span></a>' +
                '<a href="#"><span class="glyphicon glyphicon-remove">删除</span></a>' +
                '</td>' +
                '</tr>';


        });



        $(tableValue).html(table_code);
    }
}


/**
 * ===========================================================================
 * 用例组相关js
 */

GROUP.changeModalWordToAdd = function(id_1, id_2) {
    $(id_1).text('新建组');
    $(id_2).text('新建');
}
GROUP.changeModalWordToUpdate = function(id_1, id_2) {
    $(id_1).text('编辑组');
    $(id_2).text('更改');
}


GROUP.addGroup = function(pathId, id_1, id_2) {
    GROUP.changeModalWordToAdd(id_1, id_2);
    $.ajax({
        url: hostSite + ":" + serverPort + "/project", //请求的URL
        timeout: 500, //超时时间设置，单位毫秒
        type: 'get', //请求方式，get或post
        data: {}, //请求所传参数，json格式
        dataType: 'json', //返回的数据格式
        success: function(data) { //请求成功的回调函数


            GROUP.drewTables(data, pathId);
        },
        complete: function(XMLHttpRequest, status) { //请求完成后最终执行参数

            if (status == 'timeout') { //超时,status还有success,error等值的情况

                ajaxTimeoutTest.abort();
                alert("超时");
            }
        }
    });
}

GROUP.drewTables = function(data, pathId) {
    var table_code = '';
    $.each(data, function(key, val) {

        table_code = table_code + '<option id="' + this.id + '">' + this.title + '</option>';


    });
    $(pathId).html(table_code);
}




GROUP.getBaseurlListByAjax = function(tableBody, tableValue) {
    $.ajax({
        url: hostSite + ":" + serverPort + "/baseurl", //请求的URL
        //timeout: 500, //超时时间设置，单位毫秒
        type: 'get', //请求方式，get或post
        data: {}, //请求所传参数，json格式
        dataType: 'json', //返回的数据格式
        success: function(data) { //请求成功的回调函数


            GROUP.drewTables(data, tableBody, tableValue);
        },
        complete: function(XMLHttpRequest, status) { //请求完成后最终执行参数

            if (status == 'timeout') { //超时,status还有success,error等值的情况

                ajaxTimeoutTest.abort();
                alert("超时");
                $(tableBody).html(' <div style="text-align:center;font-size:22px;"> <p></p><span class="glyphicon glyphicon-glass"><label><b> 连接超时，刷新试试！</b></lable></span><p></p></div>');
            } else if (XMLHttpRequest.status == 500) {
                $(tableBody).html(' <div style="text-align:center;font-size:22px;"> <p></p><span class="glyphicon glyphicon-warning-sign"><label><b> 服务器异常！</b></lable></span><p></p></div>');
            }
        }
    });

}

GROUP.drewTables = function(data, tableBody, tableValue) {

    //var data = null;
    //data_list = JSON.parse(data);
    var table_code = '';

    if (data.length == 0) {
        var table_null = ' <div style="text-align:center;font-size:22px;"> <p></p><span class="glyphicon glyphicon-glass"><label><b> 还没有项目，快去建立吧！</b></lable></span><p></p></div>';

        $(tableBody).html(table_null);
    } else {
        $.each(data, function(key, val) {

            table_code = table_code +
                '<tr><td>' + this.baseurl + '</td>' +
                '<td>' + this.comment + '</td>' +
                '<td>' + TIMETOOL.changeYYMMDD(this.createTime, true, 8) + '</td>' +
                '<td>' + TIMETOOL.changeYYMMDD(this.updateTime) + '</td>' +
                '<td>' +
                '<td><a href="#"><span class="glyphicon glyphicon-pencil">查看</span></a>' +
                ' <a href="#"><span class="glyphicon glyphicon-pencil">修改</span></a>' +
                '<a href="#"><span class="glyphicon glyphicon-remove">删除</span></a>' +
                '</td>' +
                '</tr>';


        });



        $(tableValue).html(table_code);
    }
}


/**
 * ===========================================================================
 * 接口
 */


//获取选择项目列表的 id
APIPATH.getSelectOption = function() {
    //alert($("#selectProject").find("option:selected").text());
    return $("#selectProject").find("option:selected").attr('id');
}



APIPATH.getProjectListByAjax = function(pathId) {
    $('#myModalLabel').text("新建");
    $('#pathInput').val('');
    $('#inputComment').val('');
    $('#myModalButton').attr("onclick", "APIPATH.addBaseUrl()");
    $.ajax({
        url: hostSite + ":" + serverPort + "/project", //请求的URL
        //timeout: 500, //超时时间设置，单位毫秒
        type: 'get', //请求方式，get或post
        data: {}, //请求所传参数，json格式
        dataType: 'json', //返回的数据格式
        success: function(data) { //请求成功的回调函数


            APIPATH.drewAddButtonProjectList(data, pathId);
        },
        complete: function(XMLHttpRequest, status) { //请求完成后最终执行参数

            if (status == 'timeout') { //超时,status还有success,error等值的情况

                ajaxTimeoutTest.abort();
                alert("请求超时");
            } else if (XMLHttpRequest.status == 500) {
                alert("服务器故障！");
            }
        }
    });

}


/**
 * {
    "apiPath": "string",
    "comment": "string",
    "projectId": 0
    }
 */
//添加baseurl
APIPATH.addBaseUrl = function() {
    if ($('#pathInput').val() == '') {
        alert("地址不能为空");
    } else {


        if ($('#addButton').attr("name") == 'baseURL') {
            var jsonData = '{' +
                '"baseurl": "' + $('#pathInput').val() + '",' +
                '"comment": "' + $('#inputComment').val() + '",' +
                '"projectId":' + APIPATH.getSelectOption() + '}';


            APIPATH.addBaseUrlByPost(jsonData);
        } else {

            var jsonData = '{' +
                '"apiPath": "' + $('#pathInput').val() + '",' +
                '"comment": "' + $('#inputComment').val() + '",' +
                '"projectId":' + APIPATH.getSelectOption() + '}';
            APIPATH.addApiByPost(jsonData);
        }

    }
}

/**
 * post添加baseurl
 */
APIPATH.addBaseUrlByPost = function(jsonData) {
    $.ajax({
        type: 'POST',
        url: hostSite + ":" + serverPort + "/baseurl",
        //timeout: 500, //超时时间设置，单位毫秒
        contentType: "application/json; charset=utf-8",
        data: jsonData,
        dataType: 'json', //返回的数据格式
        success: function(data) { //请求成功的回调函数
            APIPATH.getBaseurlListByAjax('#tableBody', '#tableValue');
            //location.reload();
        },
        complete: function(XMLHttpRequest, status) { //请求完成后最终执行参数
            if (status == 'timeout') { //超时,status还有success,error等值的情况

                ajaxTimeoutTest.abort();
                alert("超时");

            } else if (XMLHttpRequest.status == 500) {
                alert("服务器异常！");
            }
        }
    });
}

/**
 *
 * 重新加载
 */



/**
 * post添加apipath
 */
APIPATH.addApiByPost = function(jsonData) {
    $.ajax({
        type: 'POST',
        url: hostSite + ":" + serverPort + "/apipath",
        //timeout: 500, //超时时间设置，单位毫秒
        data: jsonData,
        contentType: "application/json; charset=utf-8",
        dataType: 'json', //返回的数据格式
        success: function(data) { //请求成功的回调函数
            APIPATH.getApiListByAjax('#tableBody', '#tableValue');
            //location.reload();
        },
        complete: function(XMLHttpRequest, status) { //请求完成后最终执行参数

            if (status == 'timeout') { //超时,status还有success,error等值的情况

                ajaxTimeoutTest.abort();
                alert("超时");

            } else if (XMLHttpRequest.status == 500) {
                alert("服务器异常！");
            }
        }
    });
}


APIPATH.selectAddBaseurlType = function() {
    $('#apiLi').removeClass('active');
    $('#baseUrlLi').attr('class', 'active');
    $('#baseurlTitle').html("BaseURL：");
    $('#pathInput').attr('placeholder', 'BaseURL');
    $('#addButton').attr('name', 'baseURL');

    APIPATH.getBaseurlListByAjax('#tableBody', '#tableValue');
}

APIPATH.selectAddApiType = function() {
    $('#apiLi').attr('class', 'active');
    $('#baseUrlLi').removeClass('active');
    $('#baseurlTitle').html("地址：");
    $('#pathInput').attr('placeholder', '接口地址');
    $('#addButton').attr('name', 'apiPath');
    APIPATH.getApiListByAjax('#tableBody', '#tableValue');
}




APIPATH.getApiListByAjax = function(tableBody, tableValue) {
    $.ajax({
        url: hostSite + ":" + serverPort + "/apipath", //请求的URL
        timeout: 500, //超时时间设置，单位毫秒
        type: 'get', //请求方式，get或post
        data: {}, //请求所传参数，json格式
        dataType: 'json', //返回的数据格式
        success: function(data) { //请求成功的回调函数


            APIPATH.drewTablesByApiPath(data, tableBody, tableValue);
        },
        complete: function(XMLHttpRequest, status) { //请求完成后最终执行参数

            if (status == 'timeout') { //超时,status还有success,error等值的情况

                ajaxTimeoutTest.abort();
                alert("超时");
                $(tableBody).html(' <div style="text-align:center;font-size:22px;"> <p></p><span class="glyphicon glyphicon-glass"><label><b> 连接超时，刷新试试！</b></lable></span><p></p></div>');
            } else if (XMLHttpRequest.status == 500) {
                $(tableBody).html(' <div style="text-align:center;font-size:22px;"> <p></p><span class="glyphicon glyphicon-warning-sign"><label><b> 服务器异常！</b></lable></span><p></p></div>');
            }
        }
    });
}

APIPATH.drewAddButtonProjectList = function(data, pathId) {
    var table_code = '';
    $.each(data, function(key, val) {
        table_code = table_code + '<option id="' + this.id + '">' + this.title + '</option>';
    });
    $(pathId).html(table_code);

}




APIPATH.getBaseurlListByAjax = function(tableBody, tableValue) {

    $.ajax({
        url: hostSite + ":" + serverPort + "/baseurl", //请求的URL
        //timeout: 500, //超时时间设置，单位毫秒
        type: 'get', //请求方式，get或post
        data: {}, //请求所传参数，json格式
        dataType: 'json', //返回的数据格式
        success: function(data) { //请求成功的回调函数


            APIPATH.drewTablesByBaseUrl(data, tableBody, tableValue);

        },
        complete: function(XMLHttpRequest, status) { //请求完成后最终执行参数

            if (status == 'timeout') { //超时,status还有success,error等值的情况

                ajaxTimeoutTest.abort();
                alert("超时");
                $(tableBody).html(' <div style="text-align:center;font-size:22px;"> <p></p><span class="glyphicon glyphicon-glass"><label><b> 连接超时，刷新试试！</b></lable></span><p></p></div>');
            } else if (XMLHttpRequest.status == 500) {
                $(tableBody).html(' <div style="text-align:center;font-size:22px;"> <p></p><span class="glyphicon glyphicon-warning-sign"><label><b> 服务器异常！</b></lable></span><p></p></div>');
            }
        }
    });

}

APIPATH.drewTablesByBaseUrl = function(data, tableBody, tableValue) {

    //var data = null;
    //data_list = JSON.parse(data);
    var table_code = '';

    if (data.length == 0) {
        var table_null = ' <div style="text-align:center;font-size:22px;"> <p></p><span class="glyphicon glyphicon-glass"><label><b> 还没有BaseURL，快去建立吧！</b></lable></span><p></p></div>';

        $(tableBody).html(table_null);
    } else {
        $.each(data, function(key, val) {

            table_code = table_code +
                '<tr><td>' + this.baseurl + '</td>' +
                '<td>' + this.comment + '</td>' +
                '<td>' + TIMETOOL.changeYYMMDD(this.createTime, true, 8) + '</td>' +
                '<td>' + TIMETOOL.changeYYMMDD(this.updateTime) + '</td>' +
                '<td>' +
                ' <a href="#" data-toggle="modal" data-target="#myModal" onclick="APIPATH.getBaseUrl(' + this.id + ')"><span class="glyphicon glyphicon-pencil">修改</span></a>' +
                '<a href="#" onclick="APIPATH.deleteBaseUrl(' + this.id + ',' + '\'#tableBody\',\'#tableValue\')"><span class="glyphicon glyphicon-remove" >删除</span></a>' +
                '</td>' +
                '</tr>';


        });

        debugger;
        alert(table_code);

        $(tableValue).html(table_code);
    }
}


APIPATH.drewTablesByApiPath = function(data, tableBody, tableValue) {

    //var data = null;
    //data_list = JSON.parse(data);
    var table_code = '';

    if (data.length == 0) {
        var table_null = ' <div style="text-align:center;font-size:22px;"> <p></p><span class="glyphicon glyphicon-glass"><label><b> 还没有API，快去建立吧！</b></lable></span><p></p></div>';

        $(tableBody).html(table_null);
    } else {
        $.each(data, function(key, val) {

            table_code = table_code +
                '<tr><td>' + this.apiPath + '</td>' +
                '<td>' + this.comment + '</td>' +
                '<td>' + TIMETOOL.changeYYMMDD(this.createTime, true, 8) + '</td>' +
                '<td>' + TIMETOOL.changeYYMMDD(this.updateTime) + '</td>' +
                '<td>' +
                ' <a href="#" data-toggle="modal" data-target="#myModal" onclick="APIPATH.getApipath(' + this.id + ') "><span class="glyphicon glyphicon-pencil" >修改</span></a>' +
                '<a href="#" onclick="APIPATH.deleteAPI(' + this.id + ',' + '\'#tableBody\',\'#tableValue\')"><span class="glyphicon glyphicon-remove">删除</span></a>' +
                '</td>' +
                '</tr>';


        });



        $(tableValue).html(table_code);
    }
}


APIPATH.deleteBaseUrl = function(id, tableBody, tableValue) {
    $.ajax({
        url: hostSite + ":" + serverPort + "/baseurl/" + id, //请求的URL
        timeout: 500, //超时时间设置，单位毫秒
        type: 'delete', //请求方式，get或post
        data: {}, //请求所传参数，json格式
        dataType: 'json', //返回的数据格式
        success: function(data) { //请求成功的回调函数

            //location.reload();　　　


        },
        complete: function(XMLHttpRequest, status) {
            //alert("删除成功！"); //请求完成后最终执行参数

            APIPATH.getBaseurlListByAjax(tableBody, tableValue);
            //location.reload();　　
        }
    });

}

APIPATH.deleteAPI = function(id, tableBody, tableValue) {
    $.ajax({
        url: hostSite + ":" + serverPort + "/apipath/" + id, //请求的URL
        timeout: 500, //超时时间设置，单位毫秒
        type: 'delete', //请求方式，get或post
        data: {}, //请求所传参数，json格式
        dataType: 'json', //返回的数据格式
        success: function(data) { //请求成功的回调函数

            //location.reload();　　　


        },
        complete: function(XMLHttpRequest, status) {
            //alert("删除成功！"); //请求完成后最终执行参数

            APIPATH.getApiListByAjax(tableBody, tableValue);
            //location.reload();　　
        }
    });

}

APIPATH.updateBaseUrl = function(id, tableBody, tableValue) {
    if ($('#pathInput').val() == '') {
        alert("地址不能为空");
    } else {
        var jsonData = '{' +
            '"baseurl": "' + $('#pathInput').val() + '",' +
            '"comment": "' + $('#inputComment').val() + '",' +
            '"projectId":' + APIPATH.getSelectOption() + '}';
        //发送修改请求
        $.ajax({
            type: 'PUT',
            url: hostSite + ":" + serverPort + "/baseurl/" + id,
            timeout: 500, //超时时间设置，单位毫秒
            contentType: "application/json; charset=utf-8",
            data: jsonData,
            dataType: 'json', //返回的数据格式
            success: function(data) { //请求成功的回调函数
                APIPATH.getBaseurlListByAjax('#tableBody', '#tableValue');
                //location.reload();
            },
            complete: function(XMLHttpRequest, status) { //请求完成后最终执行参数
                if (status == 'timeout') { //超时,status还有success,error等值的情况

                    ajaxTimeoutTest.abort();
                    alert("超时");

                } else if (XMLHttpRequest.status == 500) {
                    alert("服务器异常！");
                }
                if (XMLHttpRequest.status == 200) {
                    //修改成功后关闭模态框
                    $('#myModal').modal('hide');
                }
            }
        });
    }

}

APIPATH.getBaseUrl = function(id) {
    var projectId;
    $.ajax({
        url: hostSite + ":" + serverPort + "/getBaseurl/" + id, //请求的URL
        timeout: 500, //超时时间设置，单位毫秒
        type: 'get', //请求方式，get或post
        data: {}, //请求所传参数，json格式
        dataType: 'json', //返回的数据格式
        success: function(data) { //请求成功的回调函数

            //alert('baseurl: ' + data.baseurl + 'projectId: ' + data.projectId + 'Id: ' + data.id);

            //location.reload();　　　
            $('#pathInput').val(data.baseurl);
            $('#inputComment').val(data.comment);
            // $('#selectProject').val(data.projectId);
            projectId = data.projectId;
            //alert(data.projectId);

        },
        complete: function(XMLHttpRequest, status) {
            //alert("删除成功！"); //请求完成后最终执行参数
            //location.reload();　

            if (status == 'success') {
                //alert("status: " + status)　;
                $.ajax({
                    url: hostSite + ":" + serverPort + "/project", //请求的URL
                    timeout: 500, //超时时间设置，单位毫秒
                    type: 'get', //请求方式，get或post
                    data: {}, //请求所传参数，json格式
                    dataType: 'json', //返回的数据格式
                    success: function(data) { //请求成功的回调函数
                        //alert(projectId);　

                        APIPATH.drewProjectOptionSelect(data, '#selectProject', projectId);
                    },
                    complete: function(XMLHttpRequest, status) { //请求完成后最终执行参数

                        if (status == 'timeout') { //超时,status还有success,error等值的情况

                            ajaxTimeoutTest.abort();
                            alert("请求超时");
                        } else if (XMLHttpRequest.status == 500) {
                            alert("服务器故障！");
                        }
                    }
                });
                $('#myModalLabel').text("编辑");
                $('#myModalButton').attr("onclick", "APIPATH.updateBaseUrl(" + id + ")");
                //debugger;
            }

        }
    });




}

/**
 * 更新api
 */
APIPATH.updateApipath = function(id, tableBody, tableValue) {
    if ($('#pathInput').val() == '') {
        alert("地址不能为空");
    } else {
        var jsonData = '{' +
            '"apiPath": "' + $('#pathInput').val() + '",' +
            '"comment": "' + $('#inputComment').val() + '",' +
            '"projectId":' + APIPATH.getSelectOption() + '}';
        //发送修改请求
        $.ajax({
            type: 'PUT',
            url: hostSite + ":" + serverPort + "/apipath/" + id,
            timeout: 500, //超时时间设置，单位毫秒
            contentType: "application/json; charset=utf-8",
            data: jsonData,
            dataType: 'json', //返回的数据格式
            success: function(data) { //请求成功的回调函数
                APIPATH.getApiListByAjax('#tableBody', '#tableValue');
                //location.reload();
            },
            complete: function(XMLHttpRequest, status) { //请求完成后最终执行参数
                if (status == 'timeout') { //超时,status还有success,error等值的情况

                    ajaxTimeoutTest.abort();
                    alert("超时");

                } else if (XMLHttpRequest.status == 500) {
                    alert("服务器异常！");
                }
                if (XMLHttpRequest.status == 200) {
                    //修改成功后关闭模态框
                    $('#myModal').modal('hide');
                }
            }
        });
    }

}

APIPATH.getApipath = function(id) {
    var projectId;
    $.ajax({
        url: hostSite + ":" + serverPort + "/apipath/" + id, //请求的URL
        timeout: 500, //超时时间设置，单位毫秒
        type: 'get', //请求方式，get或post
        data: {}, //请求所传参数，json格式
        dataType: 'json', //返回的数据格式
        success: function(data) { //请求成功的回调函数

            //alert('baseurl: ' + data.baseurl + 'projectId: ' + data.projectId + 'Id: ' + data.id);

            //location.reload();　　　
            $('#pathInput').val(data.apiPath);
            $('#inputComment').val(data.comment);
            // $('#selectProject').val(data.projectId);
            projectId = data.projectId;
            //alert(data.projectId);

        },
        complete: function(XMLHttpRequest, status) {
            //alert("删除成功！"); //请求完成后最终执行参数
            //location.reload();　

            if (status == 'success') {
                //alert("status: " + status)　;
                $.ajax({
                    url: hostSite + ":" + serverPort + "/project", //请求的URL
                    timeout: 500, //超时时间设置，单位毫秒
                    type: 'get', //请求方式，get或post
                    data: {}, //请求所传参数，json格式
                    dataType: 'json', //返回的数据格式
                    success: function(data) { //请求成功的回调函数
                        //alert(projectId);　

                        APIPATH.drewProjectOptionSelect(data, '#selectProject', projectId);
                    },
                    complete: function(XMLHttpRequest, status) { //请求完成后最终执行参数

                        if (status == 'timeout') { //超时,status还有success,error等值的情况

                            ajaxTimeoutTest.abort();
                            alert("请求超时");
                        } else if (XMLHttpRequest.status == 500) {
                            alert("服务器故障！");
                        }
                    }
                });
                $('#myModalLabel').text("编辑");
                $('#myModalButton').attr("onclick", "APIPATH.updateApipath(" + id + ")");
                //debugger;
            }

        }
    });




}


APIPATH.drewProjectOptionSelect = function(data, pathId, projectId) {
    //alert(projectId);
    var table_code = '';

    for (var i = 0; i < data.length; i++) {
        //debugger;
        table_code = table_code + '<option id="' + data[i].id + '">' + data[i].title + '</option>';
    }

    /*
     $.each(data, function(key, val) {
     if (this.id == projectId) {
     alert(this.id);
     }
     table_code = table_code + '<option id="' + this.id + '">' + this.title + '</option>';


     });
     */
    //alert(table_code);
    $(pathId).html(table_code);
    $('#' + projectId).attr("selected", true);

    //$('#' + projectId).attr("selected", true);

    //$('#100003').attr("selected", "selected"); //.selected = true;
}

/**
 * ===========================================================================
 * 其他工具函数
 */

TIMETOOL.changeYYMMDD = function(unixTime, timeZone) {
    if (typeof(timeZone) == 'number') {
        unixTime = parseInt(unixTime) + parseInt(timeZone) * 60 * 60;
    }
    var time = new Date(unixTime);
    var ymdhis = "";
    ymdhis += time.getFullYear() + "年";
    ymdhis += (time.getMonth() + 1) + "月";
    ymdhis += time.getUTCDate() + "日";

    ymdhis += " " + TIMETOOL.addZero(time.getHours()) + ":";
    ymdhis += TIMETOOL.addZero(time.getMinutes()) + ":";
    ymdhis += TIMETOOL.addZero(time.getSeconds());

    return ymdhis;

}
TIMETOOL.addZero = function(second) {

    if (second < 10) {
        return "0" + second;
    } else {
        return second;
    }
}



　　