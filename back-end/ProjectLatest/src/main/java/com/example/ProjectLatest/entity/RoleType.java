package com.example.ProjectLatest.entity;

public enum RoleType {
	WORKER("worker"),RESIDENT("resident"),ADMIN("admin");
<<<<<<< HEAD

=======
>>>>>>> 6b816359d0104da0ba74f438b7e1778ff0a99757
	String roleType;
	RoleType(String roleType)
	{
		this.roleType = roleType;
	}

	public String toString()
	{
		return roleType;
	}

}
