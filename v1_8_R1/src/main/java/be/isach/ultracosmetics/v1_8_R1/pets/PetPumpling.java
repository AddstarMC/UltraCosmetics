package be.isach.ultracosmetics.v1_8_R1.pets;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.PetType;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.util.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Zombie;
import org.bukkit.util.Vector;

import java.util.Random;
import java.util.UUID;

/**
 * @author RadBuilder
 */
public class PetPumpling extends CustomEntityPet {

	Random r = new Random();

	public PetPumpling(UltraPlayer ultraPlayer, UltraCosmetics ultraCosmetics) {
		super(ultraPlayer, ultraCosmetics, PetType.PUMPLING);
	}

	@Override
	public void onUpdate() {
		final Item ITEM = customEntity.getEntity().getWorld().dropItem(((Zombie) customEntity.getEntity()).getEyeLocation(), ItemFactory.create(Material.JACK_O_LANTERN, (byte) 0x0, UUID.randomUUID().toString()));
		ITEM.setPickupDelay(30000);
		ITEM.setVelocity(new Vector(r.nextDouble() - 0.5, r.nextDouble() / 2.0 + 0.3, r.nextDouble() - 0.5).multiply(0.4));
		items.add(ITEM);
		Bukkit.getScheduler().runTaskLater(getUltraCosmetics(), () -> {
			ITEM.remove();
			items.remove(ITEM);
		}, 5);
	}
}
