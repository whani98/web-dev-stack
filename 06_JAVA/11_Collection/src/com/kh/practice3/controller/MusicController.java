package com.kh.practice3.controller;

import java.util.ArrayList;

import com.kh.practice3.model.Music;

public class MusicController {

	private ArrayList<Music> list = new ArrayList<>();

	// 1. 특정 곡 추가
	public boolean addList(String artist, String song) {
//		add
		Music music = new Music();
		music.setArtist(artist);
		music.setSong(song);
		list.add(music);

		for (Music l : list) {
			if(l.getArtist().equals(artist) && l.getSong().equals(song)) {
				return false;
			}
		}
		return true;
	}

	// 2. 전체 곡 목록 출력
	public void printAll() {

	}

	// 3. 특정 곡 검색
	public void searchMusic() {
//		contains
	}

	// 4. 특정 곡 수정
	public void updateMusic() {
		// set

	}

	// 5. 특정 곡 삭제
	public void removeMusic() {
		// remove

	}

}