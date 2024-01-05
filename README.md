
<h1 align="center">
  <br>
  <a href="http://www.crowtycraft.es"><img src="https://img.crowtycraft.es/img/logo-cw-main.png" alt="CrowtyCraftNT" width="200"></a>
  <br>
  CrowtyCraft Network
  <br>
</h1>

<h4 align="center">As many of you already know, "CrowtyCraft Network was born from a project between great friends, providing characteristic development ideas.", which is why we make public the following article about the past server closure, global updates and the status of our administrative team.</h4>

<p align="center">
  <a href="#features">Features</a> •
  <a href="#configuration">Configuration</a> •
  <a href="#how-to-use">How to use</a> •
  <a href="#download">Download</a>
</p>

## Features

* In recent versions of Minecraft, more banners, designs, and entities have been added, as well as new editing features. We know how annoying this can be on a public server, since anyone could edit other users' posters. 

* It can be prevented naturally by applying honey on the sign, but there are always some clueless users and they can change things without your consent. 

* That is why this plugin with amazing features has been created to prevent this useful but sometimes annoying function.


## Configuration

```bash
#AntiSignEdit - Original idea from MauriceBtK | https://www.spigotmc.org/resources/disable-edit-signs-1-0.110653/

#Updated by LucasInDev, sysadmin on CrowtyCraft Network - Join us! | https://crowtycraft.es

#Social links: https://go.crowtycraft.es/social
#Help & Support: https://help.crowtycraft.es
#TrustPilot: https://go.crowtycraft.es/trustpilot

#Play with us! : https://crowtycraft.es


#  WAAAAAAARNING, I HAVE A VERY BAD ENGLISH, SO... SORRY :/

config:
  #If the user or group has this permission, they will be able to edit signs
  permission: 'crowty.edit.sign'

  #Per-World settings
  enabled-worlds:
    enabled: false #Enable or disable per-world sign edit
    #This feature allow to edit signs in specified worlds if you need it
    #⚠️CAUTION:  If a user has the permission indicated above, they will be able to edit the poster even if they are in a world where it is prohibited
    worlds:
      - "World1"
      - "World2"
      - "World3"

  #Sound option
  sound:
    enabled: true #Enable or disable sound play on deny sign edit
    sound-type: BLOCK_CANDLE_EXTINGUISH #https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Sound.html
    #If you want change this sound, check Spigot-API

  #Special effect section
  effects:
    enabled: false
    #This feature allow to send effect to player have been denied edit of a sign
    effect-type: BLINDNESS #https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/potion/PotionEffectType.html
    effect-duration: 40 #Value in Ticks, so value of: '20' is 1 second
    #If you want change this effect, check Spigot-API


  #Language section
  prefix: '&6&lCrowtyCraftNT'
  nopermission: '&c&lHey! &7You dont have permission to edit this sign...'

  #All about color codes (External website):  https://minecraftitemids.com/color-codes

  #For message, it's better '§' to use color codes, it's a good practice of optimization, example: §6§lCrowtyCraftNT
```


## How To Use

* Just download and drop it into your /plugins folder

> **Note**
> This plugin has been tested on 1.19.X and 1.20.X (Works fine)


## Download

You can [download](https://github.com/LucasitoInDev/crowty-anti-sign-edit/releases/tag/1.0-SNAPSHOT) the last updated version
