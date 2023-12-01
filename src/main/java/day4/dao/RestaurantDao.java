package day4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;

import day4.beans.Restaurant;
import day4.utils.JdbcUtils;


public class RestaurantDao implements DaoInterface<Restaurant, Integer> {

	@Override
	public Collection<Restaurant> getAll() {
		// TODO Auto-generated method stub
		String subQuery = "select restaurantId, name, cuisine, branchCount from restaurant";
		Collection<Restaurant> allData = null;
		
		try(Connection conn = JdbcUtils.buildConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(subQuery)) {
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String cuisine = rs.getString(3);
				int branchCount = rs.getInt(4);
				
				Restaurant res = new Restaurant(id, name, cuisine, branchCount);
				allData.add(res);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return allData;
	}

	
	@Override
	public Restaurant getOne(Integer id) {
		// TODO Auto-generated method stub
		Restaurant foundRestaurant = null;
		
		try (Connection conn = JdbcUtils.buildConnection()){
			String sqlQuery = "select restaurantId, name, cuisine, branchCount from restaurant where restaurantId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int r_id = rs.getInt(1);
				String name = rs.getString(2);
				String cuisine = rs.getString(3);
				int branchCount = rs.getInt(4);
				
				foundRestaurant = new Restaurant(r_id, name, cuisine, branchCount);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return foundRestaurant;
	}

	@Override
	public void create(Restaurant newRestaurant) {
		// TODO Auto-generated method stub
		String subQuery = "insert into restaurant(restaurantId, name, cuisine, branchCount) values(?,?,?,?)";
		try(Connection conn = JdbcUtils.buildConnection();
				PreparedStatement pstmt= conn.prepareStatement(subQuery)) {
			int id= newRestaurant.getRestaurantId();
			String name = newRestaurant.getName();
			String cuisine = newRestaurant.getCuisine();
			int branchCount = newRestaurant.getBranchCount();
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, cuisine);
			pstmt.setInt(4, branchCount);
			
			int count = pstmt.executeUpdate();
			System.out.println(count+" records inserted");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String subQuery = "Delete from restaurant where restaurantId = ?";
		try (Connection conn = JdbcUtils.buildConnection();
				PreparedStatement pstmt = conn.prepareStatement(subQuery)){
			pstmt.setInt(1, id);
			int count = pstmt.executeUpdate();
			System.out.println(count+" record deleted");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Restaurant updateRestaurant) {
		// TODO Auto-generated method stub
		String subQuery = "update restaurant set name=?, cuisine=?, branchCount=? where restaurantId=?";
		try(Connection conn = JdbcUtils.buildConnection();
				PreparedStatement pstmt = conn.prepareStatement(subQuery)) {
			int id = updateRestaurant.getRestaurantId();
			String name = updateRestaurant.getName();
			String cuisine = updateRestaurant.getCuisine();
			int branchCount = updateRestaurant.getBranchCount();
			
			pstmt.setInt(4, id);
			pstmt.setString(1, name);
			pstmt.setString(2, cuisine);
			pstmt.setInt(3, branchCount);
			int count = pstmt.executeUpdate();
			System.out.println(count+" record Updated");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
