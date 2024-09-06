package dev.igalaxy.marspopsicle.tempmodifiers;

import com.momosoftworks.coldsweat.api.temperature.modifier.TempModifier;
import com.momosoftworks.coldsweat.api.util.Temperature;
import com.momosoftworks.coldsweat.api.util.Temperature.Units;
import com.petrolpark.destroy.capability.level.pollution.LevelPollution.PollutionType;
import com.petrolpark.destroy.util.PollutionHelper;
import earth.terrarium.adastra.api.systems.OxygenApi;
import earth.terrarium.adastra.common.constants.PlanetConstants;
import net.minecraft.world.entity.LivingEntity;

import java.util.function.Function;

public class OxygenTempModifier extends TempModifier {
    @Override
    protected Function<Double, Double> calculate(LivingEntity livingEntity, Temperature.Trait trait) {
        if (!livingEntity.level().isClientSide) {
            if (!OxygenApi.API.hasOxygen(livingEntity.level())) {
                if (OxygenApi.API.hasOxygen(livingEntity.level(), livingEntity.blockPosition())) {
                    return temp -> Temperature.convert(PlanetConstants.COMFY_EARTH_TEMPERATURE, Units.C, Units.MC, true);
                }
            }
        }
        return temp -> temp;
    }
}
