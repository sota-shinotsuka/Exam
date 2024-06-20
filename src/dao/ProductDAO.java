package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Product;

public class ProductDAO extends DAO {
//  商品名で検索するメソッド
	public List<Product> search(String keyword) throws Exception{
//		Productを要素に持つList
		List<Product> list = new ArrayList<Product>();

//		データベースから商品を検索してリストに追加する処理
//		データベースに接続
		Connection con = getConnection();

//		データベースを使った処理を実行

//		実行したいSQL文をプリペアードステートメントで準備
//		"?" -> プレースホルダー
		PreparedStatement st = con.prepareStatement(
//				SQLインジェクション対策
				"select * from product where name like ?");
//		st.setStringメソッド…プリペアードステートメント
//		のプレースホルダーに値を埋め込む（バインド）する
//		第1引数＝プレースホルダ番号
		st.setString(1, "%"+keyword+"%");
//		SQL文を実行した結果をリザルトセットに格納
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
//			Productクラスをインスタンス化
			Product p = new Product();
//			値をセット
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
//			リストに追加
			list.add(p);
		}

//		データベースとの接続を解除
		st.close();
		con.close();

//		商品リストを返却
		return list;
	}

//	すべての商品を参照するメソッド
	public List<Product> all() throws Exception{
//		Productを要素に持つList
		List<Product> list = new ArrayList<Product>();

//		データベースに接続
		Connection con = getConnection();

//		実行したいSQL文をプリペアードステートメントで準備
		PreparedStatement st = con.prepareStatement(
				"select * from product ");

//		SQL文を実行した結果をリザルトセットに格納
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
//			Productクラスをインスタンス化
			Product p = new Product();
//			値をセット
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
//			リストに追加
			list.add(p);
		}

//		データベースとの接続を解除
		st.close();
		con.close();
		return list;

	}

//	商品を登録するメソッド
	public int insert(Product product) throws Exception {
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
			"insert into product values(null, ?, ?)");
		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

//	IDを指定して商品を取得するメソッドget
	public Product get(int id) throws Exception{
		Connection con = getConnection();

		PreparedStatement  st=con.prepareStatement(
			"select * from product where id = ?");

		st.setInt(1, id);

		ResultSet rs = st.executeQuery();

		Product p = new Product();
		if (rs.next()) {

			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
		}else{
			p=null;
		}

		return p;
	}
}
