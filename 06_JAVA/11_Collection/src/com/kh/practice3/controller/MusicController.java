package com.kh.practice3.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.practice3.SongAscending;
import com.kh.practice3.model.Music;

public class MusicController {

	private ArrayList<Music> list = new ArrayList<>();

	// 1. 특정 곡 추가
	public boolean addList(String artist, String song) {
//		add
		for (Music m : list) {
			if (m.getSong().equals(song) && m.getArtist().equals(artist)) {
				return false; // 곡명과 가수명이 같을 때만 추가가 안되도록!
			}
		}
		if (artist.trim().equals("") || song.trim().equals("")) { // .trim() :공백 제거
			return false;
		}
		return list.add(new Music(artist, song));
	}

	// 2. 전체 곡 목록 출력
	public ArrayList<Music> printAll() {
		return list;
//		for (Music m : list) {
//			System.out.println(m);
//		}
	}

	// 3. 특정 곡 검색
	public ArrayList<Music> searchMusic(String keyword) {
		ArrayList<Music> result = new ArrayList<>(); // 여러개 리스트를 나타내고 싶은 경우
//		contains
		for (Music m : list) {
			if (m.getSong().toLowerCase().contains(keyword.toLowerCase())
					|| m.getArtist().toLowerCase().contains(keyword.toLowerCase())) {
				// .equalsIgnoreCase : 대/소문자 상관없이 검색 가능
				// .toLowerCase() : 둘 다 소문자로 바꿔서 비교하도록 바꾸기
				result.add(m);
			}
		}
		return result;
	}

	// 4. 특정 곡 수정
	// 곡 검색 시 중복된 경우
	public ArrayList<Music> checkMusic(String song) {
		ArrayList<Music> result = new ArrayList<>();
		for (Music m : list) {
			if (m.getSong().equals(song)) {
				result.add(m);
			}
		}
		return result;
	}

//	특정 곡 수정 -> 1개인 경우, 여러개인 경우
	public Music updateMusic(String searchSong, String searchArtist, Music update) {
		// updateArtist와 updateSong을 update로 묶어서 나타낼 수 있음
//		set
		for (Music m : list) {
			boolean checkSong = m.getSong().equals(searchSong);
			boolean checkArtist = m.getArtist().equals(searchArtist);
			
			if (searchArtist == null && checkSong || checkSong && checkArtist) {
				// 기존 리스트에서 수정할 값이 있는 경우 - 수정 못하게!
				if(m.getSong().equals(update.getSong())
						&& m.getArtist().equals(update.getArtist())){
					return null;
				}
				return list.set(list.indexOf(m), update);
			}
		}
		return null;
	}

	// 5. 특정 곡 삭제
	public Music removeMusic(String song, String artist) {
//		remove
		for (Music m : list) {
			if (artist==null && m.getSong().equals(song) 
					|| m.getSong().equals(song) && m.getArtist().equals(artist)) {
				return list.remove(list.indexOf(m));
			}
		}
		return null;
	}
	// 가수명 내림차순
		public ArrayList<Music> descArtist() {
			ArrayList<Music> clone = (ArrayList<Music>) list.clone();
			Collections.sort(clone);
			return clone;
		}
		
		// 곡명 오름차순
		public ArrayList<Music> ascSong() {
			ArrayList<Music> clone = (ArrayList<Music>) list.clone();
			Collections.sort(clone, new SongAscending());
			return clone;
		}
	
}