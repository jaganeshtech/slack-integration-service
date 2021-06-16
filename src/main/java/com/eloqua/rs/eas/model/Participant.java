/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eloqua.rs.eas.model;

/**
 *
 * @author ganeshraja
 */
public class Participant {

//    private String id;
	private String name;
	private String user_email;
	private String device;
	private String ip_address;
//    private String user_id;
	private String user_name;
	private String email;
	private String join_time;
	private String leave_time;
	private String leave_reason;
	private int duration;
	private double Total_Duration;
	private boolean recording;
	private boolean share_application;
	private boolean share_desktop;
	private boolean share_whiteboard;

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJoin_time() {
		return join_time;
	}

	public void setJoin_time(String join_time) {
		this.join_time = join_time;
	}

	public String getLeave_time() {
		return leave_time;
	}

	public void setLeave_time(String leave_time) {
		this.leave_time = leave_time;
	}

	public String getLeave_reason() {
		return leave_reason;
	}

	public void setLeave_reason(String leave_reason) {
		this.leave_reason = leave_reason;
	}

	public boolean isRecording() {
		return recording;
	}

	public void setRecording(boolean recording) {
		this.recording = recording;
	}

	public boolean isShare_application() {
		return share_application;
	}

	public void setShare_application(boolean share_application) {
		this.share_application = share_application;
	}

	public boolean isShare_desktop() {
		return share_desktop;
	}

	public void setShare_desktop(boolean share_desktop) {
		this.share_desktop = share_desktop;
	}

	public boolean isShare_whiteboard() {
		return share_whiteboard;
	}

	public void setShare_whiteboard(boolean share_whiteboard) {
		this.share_whiteboard = share_whiteboard;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public double getTotal_Duration() {
		return Total_Duration;
	}

	public void setTotal_Duration(double total_Duration) {
		Total_Duration = total_Duration;
	}

	@Override
	public String toString() {
		return "Participant [name=" + name + ", user_email=" + user_email + ", device=" + device + ", ip_address="
				+ ip_address + ", user_name=" + user_name + ", email=" + email + ", join_time=" + join_time
				+ ", leave_time=" + leave_time + ", leave_reason=" + leave_reason + ", duration=" + duration
				+ ", Total_Duration=" + Total_Duration + ", recording=" + recording + ", share_application="
				+ share_application + ", share_desktop=" + share_desktop + ", share_whiteboard=" + share_whiteboard
				+ "]";
	}

}
