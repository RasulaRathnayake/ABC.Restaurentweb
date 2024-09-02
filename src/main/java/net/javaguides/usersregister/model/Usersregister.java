package net.javaguides.usersregister.model;

public class Usersregister {
	private static String user_id;
	private static String name;
	private static String email;
	private static String password;
	private static String role;
	public static String getUser_id() {
		return user_id;
	}
	public static void setUser_id(String user_id) {
		Usersregister.user_id = user_id;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Usersregister.name = name;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		Usersregister.email = email;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Usersregister.password = password;
	}
	public static String getRole() {
		return role;
	}
	public static void setRole(String role) {
		Usersregister.role = role;
	}



}
