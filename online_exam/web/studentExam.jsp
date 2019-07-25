<%-- 
    Document   : student_exam
    Created on : Jul 8, 2019, 3:57:06 AM
    Author     : DELL
--%>

<%@page import="com.kulchuri.exam.question.QuestionDao"%>
<%@page import="com.kulchuri.exam.question.QuestionDto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Economic Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
        <link href="css/font-awesome.css" rel="stylesheet"> 
        <link href="//fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
        <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
        <script type="text/javascript" src="../lib/jquery-1.11.2.min.js"></script>
        <script type="text/javascript">
            $(document).ready(
                    function () {
                        timeMnger();
                        var queNo = 0;
                        var Num_of_ques = $(".questionContainer").children(".queContain").length;
                        for (var temp = 0; temp < Num_of_ques; temp++) {
                            $(".paper_col").append("<span class='button'>" + (temp + 1) + "</span>");
                        }
                        $(".questionContainer").children(".queContain").eq(0).fadeIn(1000);
                        $(".next").click(function () {
                            queNo++;
                            $(".questionContainer").children(".queContain").fadeOut(1);
                            $(".questionContainer").children(".queContain").eq(queNo).fadeIn(1000);
                            if (queNo === (Num_of_ques - 1)) {
                                $(this).fadeOut(1);
                            } else {
                                $(this).fadeIn(100);
                                $(".pre").fadeIn(100);
                            }
                        });
                        $(".pre").click(function () {
                            queNo--;
                            $(".questionContainer").children(".queContain").fadeOut(1);
                            $(".questionContainer").children(".queContain").eq(queNo).fadeIn(300);
                            if (queNo === 0) {
                                $(this).hide();
                            } else {
                                $(this).fadeIn();
                                $(".next").fadeIn();
                            }
                        });

                        $("input").click(function () {
                            var ele = $(this).attr("queNo");

                            $(".paper_col ").children(".button").each(function (index, ob) {
                                if (ele == index)
                                    $(ob).css("background-color", "#A7C942");
                                //$(this).css("background-color","red").;
                            });

                        });

                        $(".button").click(function () {
                            queNo = ($(this).html()) - 1;
                            var qNo = $(this).html();
                            $(".queContain").each(function (index, ele) {
                                if (qNo == (index + 1)) {
                                    $(".queContain").fadeOut(10);
                                    $(ele).fadeIn(200);
                                }
                            });
                            if (queNo === 0) {
                                $(".pre").hide(100);
                                $(".next").fadeIn(100);
                            } else {
                                if (queNo === (Num_of_ques - 1)) {
                                    $(".next").fadeOut(100);
                                    $(".pre").fadeIn(100);
                                } else {
                                    $(".next").fadeIn(100);
                                    $(".pre").fadeIn(100);
                                }
                            }
                        });
                        $(".reset").click(function () {

                            $(".button").each(function (index, ele) {
                                if (index == queNo) {
                                    $(ele).css("background-color", "#ddd");
                                }
                            });

                            $(".quesopn input").each(function (index, ele) {

                                if ($(ele).attr("queNo") == queNo) {
                                    $(ele).removeAttr("checked");
                                }
                            });
                        });
                    });
            var totalTimeMinut = 12;
            var totalTimeSecond = 60;
            function timeMnger() {
                $(".examTime").html(totalTimeMinut + ":" + totalTimeSecond);
                if (totalTimeSecond === 0) {
                    if (totalTimeMinut === 0) {
                        $(".questionContainer").hide();
                        alert("Exam Over Your Exam is submited automatically");

                        document.examSheet.submit();
                        return;
                    }
                    totalTimeMinut--;
                    totalTimeSecond = 60;
                }
                totalTimeSecond--;
                setTimeout(timeMnger, 1000);
            }
        </script>
        <style type="text/css">
            .container{
                min-height: 500px;
                padding-left: 20x;
            }
            .container input[type="submit"]{
                padding: 2px;
                margin-left: 10px;
            }

            pre{
                font: 14px "Helvetica Neue", Helvetica, Arial, sans-serif;

                letter-spacing: 1px;
            }
            .questionContainer{
                min-height: 400px;
                width: 850px;
                padding: 2px 20px;

                font: 14px "Helvetica Neue", Helvetica, Arial, sans-serif;

                letter-spacing: 1px;

            }
            .queContain{
                width: 600px;
                height: 350px;
                overflow-y: auto;
                display: none;
                position: absolute;

            }
            .queContain input{
            }
            .modForm{
                width: 600px;
            }
            .timer{
                height: 40px;
                text-align: right;
            }
            .examTime{
                font-size: 30px;
            }
            .quesopn{
                list-style: none;
                padding: 10px;
            } 
            .quesopn li{
                padding: 5px;

            }
            .paperlink{

                bottom: 0px;
                width: 500px;
                z-index: 100;
            }

            .paperlink div{
                display: inline-block;
                width: 100px;
            }
            .paperlink a{
                margin-right: 40px;
                background: activecaption;
                padding: 3px 10px;
                box-shadow: inset 0px 0px 5px #F9F9F9;
                border-radius: 3px;
                cursor: pointer;

            }
            .paperlink a:hover{
                text-decoration: underline;
                color: #98bf21;
            }
            .paper_col{
                margin-top: 20px;
                display: block;
                width: 210px;
                min-height: 100px;
                background: #eee;
                float: right;
                border-radius: 5px;
                padding: 10px;
            }
            .paper_col .button{
                display: inline-block;
                margin-right: 6px;
                margin-bottom: 5px;
                height: 28px;
                width: 30px;
                background: #ddd;
                box-shadow: inset 0px 0px 5px 1px #000;
                border-radius: 5px;
                text-align: center;
                padding: 0px 3px;
                padding-top: 5px;
            }

            .paper_col .button:hover{

                background: #34f;
                color: #fff;
                box-shadow: inset 0px 0px 1px 1px aqua;
                cursor: pointer;
            }
        </style>
    </head>
    <body style="background-color: wheat">
        <%@include file="header.html" %>
        <%--<%@include file="student_menu.html" %>--%>
        <%
            ArrayList<QuestionDto> al = (ArrayList<QuestionDto>) session.getAttribute("al");
            if (al != null) {
        %>
        <div class="pageContainer">
            <div class="container">

                <form style="margin: 20px;" class="modForm" name="examSheet" action="studentResult.jsp" method="post">
                    <div class="questionContainer"> 
                        <div class="timer">Remaining Time <div class="examTime"> </div>  </div>
                        <%
                            int i = 0;
                            for (QuestionDto dto : al) {
                                i++;
                        %>
                        <div class="queContain">
                            <div style="margin: 5%">
                                <pre>
                                    <%="Q:-" + i%>
                                    <%=dto.getQuestion()%>                                                                                                                                         
                                <input type="hidden" value="<%=dto.getQid()%>" name="ques[<%=dto.getQid()%>]"/>
                                </pre>
                            </div>
                            <ul class="quesopn">
                                <li>
                                    <label>A.</label>   
                                    <input type="radio"  value="A" queNo="<%=i - 1%>" name="b[<%=i - 1%>]"/>
                                    <label><%=dto.getOption1()%></label>
                                </li>
                                <li> 
                                    <label>B.</label>
                                    <input type="radio"  value="B" queNo="<%=i - 1%>" name="b[<%=i - 1%>]"/>
                                    <label><%=dto.getOption2()%></label>
                                </li>
                                <li>
                                    <label>C.</label>
                                    <input type="radio"  value="C" queNo="<%=i - 1%>" name="b[<%=i - 1%>]"/>
                                    <label><%=dto.getOption3()%></label>
                                </li>
                                <li>
                                    <label>D.</label>
                                    <input type="radio"  value="D" queNo="<%=i - 1%>" name="b[<%=i - 1%>]"/>
                                    <label><%=dto.getOption4()%></label>
                                </li>
                                <li>
                                    <input type="radio" checked="" style="display:none"  value="none" queNo="<%=i - 1%>" name="b[<%=i - 1%>]"/>
                                </li>

                            </ul> 
                        </div>
                        <%
                            }
                        %>
                        <div class="paper_col"> 

                        </div>  

                        <div style="clear: both;"> </div>
                    </div>
                    <div style="clear: both;"> </div>
                    <div class="paperlink">
                        <div>   <a style="display: none" class="pre">Previous</a></div>
                        <div>  &nbsp; </div>
                        <div><a style="" class="reset" >Reset</a></div>
                        <div><a class="next">Next</a></div>
                    </div><div style="clear:both"> &nbsp;</div>
                    <input type="submit" value="Submit" />
                </form>
                <br>
            </div>
        </div> 

        <%
            } else {
                response.sendRedirect("studentSelectSubject.jsp");
            }
        %>
    </body>
</html>
