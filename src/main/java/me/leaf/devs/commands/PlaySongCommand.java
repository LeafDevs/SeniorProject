package me.leaf.devs.commands;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;

import me.leaf.devs.Main;
import me.leaf.devs.utils.DataUtils;
import me.leaf.devs.utils.PClass;

public class PlaySongCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        PClass pClass = DataUtils.getPlayerData((Player) sender);
        if(args.length == 0) {
            pClass.sendMessage("&c/playsong <song.nbs>");
            return true;
        }
        if(args[0].equals("moonlight-sonata")) {
            Song song = NBSDecoder.parse(new File(Main.getPlugin().getDataFolder() + File.separator + "songs" + File.separator + "moonlight.nbs"));
            RadioSongPlayer rsp = new RadioSongPlayer(song);
            rsp.setVolume((byte) 127);
            rsp.addPlayer(pClass.getPlayer());
            rsp.setPlaying(true);
            pClass.sendMessage("&aPlaying Song: &6Moonlight Sonata - Beethoven");
        } else if(args[0].equals("red-district")) {
            Song song = NBSDecoder.parse(new File(Main.getPlugin().getDataFolder() + File.separator + "songs" + File.separator + "reddistrict.nbs"));
            RadioSongPlayer rsp = new RadioSongPlayer(song);
            rsp.setVolume((byte) 127);
            rsp.addPlayer(pClass.getPlayer());
            rsp.setPlaying(true);
            pClass.sendMessage("&aPlaying Song: &6Welcome To The Red District - Leaf");
        } else if(args[0].equals("piano-solo")) {
            Song song = NBSDecoder.parse(new File(Main.getPlugin().getDataFolder() + File.separator + "songs" + File.separator + "pianosolo.nbs"));
            RadioSongPlayer rsp = new RadioSongPlayer(song);
            rsp.setVolume((byte) 127);
            rsp.addPlayer(pClass.getPlayer());
            rsp.setPlaying(true);
            pClass.sendMessage("&aPlaying Song: &6Piano #1 - Leaf");
        } else if(args[0].equals("mettalia")) {
            Song song = NBSDecoder.parse(new File(Main.getPlugin().getDataFolder() + File.separator + "songs" + File.separator + "walkwaytomettalia.nbs"));
            RadioSongPlayer rsp = new RadioSongPlayer(song);
            rsp.setVolume((byte) 127);
            rsp.addPlayer(pClass.getPlayer());
            rsp.setPlaying(true);
            pClass.sendMessage("&aPlaying Song: &6Walkway To Mattalia - Leaf");
        }
        return true;
    }
    
}
