package dev.igalaxy.marspopsicle;

import com.momosoftworks.coldsweat.api.event.core.GatherDefaultTempModifiersEvent;
import com.momosoftworks.coldsweat.api.event.core.TempModifierRegisterEvent;
import com.momosoftworks.coldsweat.api.temperature.modifier.BiomeTempModifier;
import com.momosoftworks.coldsweat.api.temperature.modifier.UndergroundTempModifier;
import com.momosoftworks.coldsweat.api.util.Placement;
import com.momosoftworks.coldsweat.api.util.Temperature;
import dev.igalaxy.marspopsicle.tempmodifiers.OxygenTempModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.Mod;

import static com.momosoftworks.coldsweat.common.capability.handler.EntityTempManager.TEMPERATURE_ENABLED_ENTITIES;

@Mod(MarsPopsicle.MODID)
public class MarsPopsicle {

  public static final String MODID = "marspopsicle";
  public static final Logger LOGGER = LogManager.getLogger();

  public MarsPopsicle() {
    MinecraftForge.EVENT_BUS.register(MarsPopsicle.class);
  }

  @SubscribeEvent
  public static void onModifiersRegister(TempModifierRegisterEvent event)
  {
    LOGGER.info("Registered oxygen temp modifier");
    event.register(new ResourceLocation(MODID, "oxygen"), OxygenTempModifier::new);
  }

  @SubscribeEvent
  public static void defaultModifiersInit(GatherDefaultTempModifiersEvent event)
  {
    if (event.getTrait() == Temperature.Trait.WORLD)
    {
      event.addModifier(new OxygenTempModifier().tickRate(10), Placement.Duplicates.BY_CLASS, Placement.of(Placement.Mode.AFTER, Placement.Order.FIRST, (mod) -> mod instanceof UndergroundTempModifier));
    }
  }
}
