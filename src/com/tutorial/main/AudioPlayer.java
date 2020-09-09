package com.tutorial.main;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import java.util.HashMap;
import java.util.Map;

public class AudioPlayer {

    public static Map<String, Sound> soundMap = new HashMap<>();
    public static Map<String, Music> musicMap = new HashMap<>();

    public static void load(){
        try {

            soundMap.put("click", new Sound("res/ClickSound.ogg"));

            musicMap.put("music", new Music("res/MillieB.ogg"));
            musicMap.put("coffin", new Music("res/Coffin.ogg"));
        }catch (SlickException e){
            e.printStackTrace();
        }
        }

        public static Music getMusic(String key){
        return musicMap.get(key);
        }
        public static Sound getSound(String key){
        return soundMap.get(key);
        }
}
