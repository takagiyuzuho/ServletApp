<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel=stylesheet type="text/css" href="css/reset.css">
<link rel=stylesheet type="text/css" href="css/style.css">
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
	<div class="inner">
		<div class="form-signup">
			<h2>検索</h2>
			<form action="search" method="post">
				<table>
					<tr>
						<td>社員ID</td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td>社員名</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>フリガナ</td>
						<td><input type="text" name="furigana"></td>
					</tr>
					<tr>
						<td>メールアドレス</td>
						<td><input type="text" name="mailaddress"></td>
					</tr>
					<tr>
						<td>部署</td>
						<td><select name="department_id">
								<option value="00">部署を選択してください</option>
								<option value="10">役員</option>
								<option value="11">人事部・総務部</option>
								<option value="12">経理部</option>
								<option value="13">システム開発事業部</option>
								<option value="14">教育事業部</option>
								<option value="15">営業企画部</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="検索"></td>
					</tr>
				</table>
			</form>
		</div>


		<div class="form-signup">
			<h2>登録</h2>
			<form action="signup" method="post">
				<table>
					<tr>
						<td>社員ID</td>
						<td><input type="text" name="id" readonly value="自動で設定されます"></td>
					</tr>
					<tr>
						<td>社員名</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>フリガナ</td>
						<td><input type="text" name="furigana"></td>
					</tr>
					<tr>
						<td>メールアドレス</td>
						<td><input type="text" name="mailaddress"></td>
					</tr>
					<tr>
						<td>パスワード（10文字以内）</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td>パスワード（再入力）</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td>部署</td>
						<td><select name="department">
								<option value="10">役員</option>
								<option value="11">人事部・総務部</option>
								<option value="12">経理部</option>
								<option value="13">システム開発事業部</option>
								<option value="14">教育事業部</option>
								<option value="15">営業企画部</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="登録"></td>
					</tr>
				</table>
			</form>
		</div>

		<div class="form-signup">
			<h2>削除</h2>
			<form action="delete" method="post">
				<table>
					<tr>
						<td>社員ID</td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="削除"></td>
					</tr>
				</table>
			</form>
		</div>

		<div class="form-signup">
			<h2>更新</h2>
			<form action="update" method="post">
				<table>
					<tr>
						<td>社員ID</td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td>社員名</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>フリガナ</td>
						<td><input type="text" name="furigana"></td>
					</tr>
					<tr>
						<td>メールアドレス</td>
						<td><input type="text" name="mailaddress"></td>
					</tr>
					<tr>
						<td>パスワード（10文字以内）</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td>パスワード（再入力）</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td>部署</td>
						<td><select name="department_id">
								<option value="10">役員</option>
								<option value="11">人事部・総務部</option>
								<option value="12">経理部</option>
								<option value="13">システム開発事業部</option>
								<option value="14">教育事業部</option>
								<option value="15">営業企画部</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="更新"></td>
					</tr>
				</table>
			</form>
		</div>

		<h2>登録者一覧</h2>
		<table>
			<tr>
				<th>社員ID</th>
				<th>社員名</th>
				<th>フリガナ</th>
				<th>メールアドレス</th>
				<th>パスワード</th>
				<th>所属部署</th>
				<th>削除</th>
			</tr>
			<tr>
				<td>2-1</td>
				<td>2-2</td>
				<td>2-3</td>
				<td>2-4</td>
				<td>2-5</td>
				<td>2-6</td>
				<td>2-7</td>
			</tr>
			<tr>
				<td>3-1</td>
				<td>3-2</td>
				<td>3-3</td>
				<td>3-4</td>
				<td>3-5</td>
				<td>3-6</td>
				<td>3-7</td>
			</tr>
			<tr>
				<td>4-1</td>
				<td>4-2</td>
				<td>4-3</td>
				<td>4-4</td>
				<td>4-5</td>
				<td>4-6</td>
				<td>4-7</td>
			</tr>
			<tr>
				<td>5-1</td>
				<td>5-2</td>
				<td>5-3</td>
				<td>5-4</td>
				<td>5-5</td>
				<td>5-6</td>
				<td>5-7</td>
			</tr>
			<tr>
	</div>
</body>
</html>