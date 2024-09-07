In the void of space, your blood will boil before you freeze to death![^1]

- Ad Astra-accurate base temperatures for each planet (and their orbits)
- Oxygen distributor stabilizes world temperature
- Space Suit provides full cold dampening and some heat dampening when it has oxygen (must wear full suit)
- Netherite Space Suit and Jet Suit provide full temperature dampening when they have oxygen (must wear full suit)

**Please disable temperature damage in the Ad Astra config.** This mod intends to replace Ad Astra's temperature system with Cold Sweat.
```json
// Disables temperature damage.
"disableTemperature": true,
```

This mod was made for a personal modpack and is not guaranteed to function properly in your modded environment or receive updates. Use at your own risk.

## Notice
Cold Sweat doesn't appear to be loading dimension temps from datapacks right now. For time time being, please add the following to your Cold Sweat world settings' dimension temperature offsets:
`["ad_astra:glacio", -20, "C"], ["ad_astra:mars", -65, "C"], ["ad_astra:mercury", 167, "C"], ["ad_astra:moon", -173, "C"], ["ad_astra:venus", 464, "C"], ["ad_astra:earth_orbit,ad_astra:moon_orbit,ad_astra:mars_orbit,ad_astra:glacio_orbit,ad_astra:mercury_orbit,ad_astra:venus_orbit", -270, "C"]`

[^1]: Blood boiling is not a feature of this mod.