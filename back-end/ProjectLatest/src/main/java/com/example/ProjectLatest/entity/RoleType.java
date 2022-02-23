package com.example.ProjectLatest.entity;

public enum RoleType {
	WORKER("worker"),RESIDENT("resident"),ADMIN("admin");
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
