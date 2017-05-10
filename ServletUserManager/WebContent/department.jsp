<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
    <div class="inner">
        <img src="images/footer_logo.png" alt="rezomeロゴ" width="150px">
        <nav>
            <ul>
                <li><a href="#">ホーム</a></li>
                <li><a href="#">ユーザー管理</a></li>
                <li><a href="#">部署管理</a></li>
            </ul>
        </nav>
    </div>
</header>
<div class="container">
        <div class="row">
            <div class="col-xs-offset-1 col-xs-10">
                <div class="panel panel-info">
                    <div class="panel-body">
                        <p>
                            <strong>検索条件</strong>
                        </p>

                        <form action="select" id="select" class="form-horizontal" method="post">
                            <div class="form-group">
                                <label class="col-xs-2 control-label" for="empId">社員ID</label>
                                <div class="col-xs-2">
                                    <input type="text" name="empId" placeholder="社員ID"
                                        class="form-control" />
                                </div>
                                <label class="col-xs-3 control-label" for="mail">メールアドレス</label>
                                <div class="col-xs-4">
                                    <input type="text" name="mail" placeholder="メールアドレス"
                                        class="form-control" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-2 control-label" for="empNm">社員名</label>
                                <div class="col-xs-3">
                                    <input type="text" name="empNm" placeholder="社員名"
                                        class="form-control" />
                                </div>
                                <label class="col-xs-2 control-label" for="empKn">フリガナ</label>
                                <div class="col-xs-3">
                                    <input type="text" name="empKn" placeholder="フリガナ"
                                        class="form-control" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-2 control-label" for="dep">所属部署</label>
                                <div class="col-xs-3">
                                    <select name="depId" class="form-control">
                                        <option value="">部署を選択してください</option>

                                            <option value="10">役員</option>

                                            <option value="11">人事・総務部</option>

                                            <option value="12">経理部</option>

                                            <option value="13">システム開発事業部</option>

                                            <option value="14">教育事業部</option>

                                            <option value="15">営業企画部</option>

                                    </select>
                                    <!--                                        <s:select list="depList" listKey="idDepartment" listValue="nmDepartment" key="depId" emptyOption="true" value="" class="form-control"/> -->
                                </div>
                                <div class="col-xs-offset-5 col-xs-2">
                                    <input type="submit" value="検索" class="btn btn-info" />
                                    <!--                                        <s:submit key="lbl.btn.select" class="btn btn-info"/> -->
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

</body>
</html>