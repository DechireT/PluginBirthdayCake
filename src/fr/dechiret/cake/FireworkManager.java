package fr.dechiret.cake;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.FireworkEffect.Builder;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireworkManager {

	static Main main;
	
	public FireworkManager(Main varr){
		FireworkManager.main = Main.INSTANCE;
		this.rockets = new HashMap<>();
		FireworkManager.main = varr;
	}
	private Map<String, Set<FireworkEffect>> rockets;
	
	public void craftEffect() {
		final Builder builder =  FireworkEffect.builder();
			
	// effet 1
	final FireworkEffect fwe1 = builder.trail(true).withColor(Color.ORANGE, Color.YELLOW).with(Type.CREEPER).build();
	rockets.put("fwe1", Collections.singleton(fwe1));		
	
	// effet 2
	final FireworkEffect fwe2 = builder.withColor(Color.AQUA, Color.GREEN, Color.BLUE, Color.LIME).with(Type.BURST).withFlicker().build();
	rockets.put("fwe2", Collections.singleton(fwe2));	
	
	// effet 3
	final FireworkEffect fwe3 = builder.trail(true).withColor(Color.LIME, Color.ORANGE, Color.RED, Color.YELLOW).withFade(Color.AQUA, Color.GREEN, Color.BLUE, Color.LIME)
			.with(Type.BALL_LARGE).build();
	rockets.put("fwe3", Collections.singleton(fwe3));
	
	// effet 4
	final FireworkEffect fwe4 = builder.withColor(Color.GREEN, Color.BLUE, Color.LIME).withFade(Color.OLIVE).with(Type.STAR).withFlicker().build();
	rockets.put("fwe4", Collections.singleton(fwe4));
	
	// effet 5
	final FireworkEffect fwe5 = builder.trail(true).withColor(Color.RED).withFade(Color.YELLOW).with(Type.BURST).build();
	rockets.put("fwe5", Collections.singleton(fwe5));
			
	// effet 6
	final FireworkEffect fwe6 = builder.withColor(Color.RED, Color.AQUA, Color.LIME ,Color.GREEN, Color.YELLOW, Color.ORANGE).with(Type.BALL_LARGE).withFlicker().build();
	rockets.put("fwe6", Collections.singleton(fwe6));
	
	}

	public void spawnFirework(Location location, String name) {
		
		final Firework firework = (Firework)location.getWorld().spawnEntity(location, EntityType.FIREWORK);
		
		final FireworkMeta fireworkMeta = ((Firework) firework).getFireworkMeta();
		
		if(rockets.containsKey(name)) {
			fireworkMeta.addEffects(rockets.get(name));
		}
		
		fireworkMeta.setPower(1);
		firework.setFireworkMeta(fireworkMeta);
		
	}
}
