package com.trafalcraft.dac.texte;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

import com.trafalcraft.dac.Main;

public class Replace {

	public static void replaceTexte(){
		File d = new File(Main.getPlugin().getDataFolder().getPath(), "texte.yml");
		
		YamlConfiguration file = YamlConfiguration.loadConfiguration(d);
		
		if(file.contains("Prefix") && file.get("Prefix") != null){
			Msg.Prefix.replaceBy(file.getString("Prefix"));
		}
		if(file.contains("No_Permission") && file.get("No_Permission") != null){
			Msg.No_Permission.replaceBy(file.getString("No_Permission"));
		}
		if(file.contains("Commande_Imcomplete") && file.get("Commande_Imcomplete") != null){
			Msg.Commande_Imcomplete.replaceBy(file.getString("Commande_Imcomplete"));
		}
		if(file.contains("Argument_Incorect") && file.get("Argument_Incorect") != null){
			Msg.Argument_Incorect.replaceBy(file.getString("Argument_Incorect"));
		}
		if(file.contains("Arene_Inexistante") && file.get("Arene_Inexistante") != null){
			Msg.Arene_Inexistante.replaceBy(file.getString("Arene_Inexistante"));
		}
		if(file.contains("No_Configure_Ingame") && file.get("No_Configure_Ingame") != null){
			Msg.No_Configure_Ingame.replaceBy(file.getString("No_Configure_Ingame"));
		}
		if(file.contains("No_config_ingame_2") && file.get("No_config_ingame_2") != null){
			Msg.No_config_ingame_2.replaceBy(file.getString("No_config_ingame_2"));
		}
		if(file.contains("arene_creee") && file.get("arene_creee") != null){
			Msg.arene_creee.replaceBy(file.getString("arene_creee"));
		}
		if(file.contains("arene_existante") && file.get("arene_existante") != null){
			Msg.arene_existante.replaceBy(file.getString("arene_existante"));
		}
		if(file.contains("lobby_config") && file.get("lobby_config") != null){
			Msg.lobby_config.replaceBy(file.getString("lobby_config"));
		}
		if(file.contains("plongeoir_config") && file.get("plongeoir_config") != null){
			Msg.plongeoir_config.replaceBy(file.getString("plongeoir_config"));
		}
		if(file.contains("lobby_event_config") && file.get("lobby_event_config") != null){
			Msg.lobby_event_config.replaceBy(file.getString("lobby_event_config"));
		}
		if(file.contains("pos1_config") && file.get("pos1_config") != null){
			Msg.pos1_config.replaceBy(file.getString("pos1_config"));
		}
		if(file.contains("pos2_config") && file.get("pos2_config") != null){
			Msg.pos2_config.replaceBy(file.getString("pos2_config"));
		}
		if(file.contains("entrer_nombre") && file.get("entrer_nombre") != null){
			Msg.entrer_nombre.replaceBy(file.getString("entrer_nombre"));
		}
		if(file.contains("config_mod") && file.get("config_mod") != null){
			Msg.config_mod.replaceBy(file.getString("config_mod"));
		}
		if(file.contains("config_maxplayer") && file.get("config_maxplayer") != null){
			Msg.config_maxplayer.replaceBy(file.getString("config_maxplayer"));
		}
		if(file.contains("config_maxpoint") && file.get("config_maxpoint") != null){
			Msg.config_maxpoint.replaceBy(file.getString("config_maxpoint"));
		}
		if(file.contains("config_status") && file.get("config_status") != null){
			Msg.config_status.replaceBy(file.getString("config_status"));
		}
		if(file.contains("status_off_mal_congig") && file.get("status_off_mal_congig") != null){
			Msg.status_off_mal_congig.replaceBy(file.getString("status_off_mal_congig"));
		}
		if(file.contains("status_deja_on") && file.get("status_deja_on") != null){
			Msg.status_deja_on.replaceBy(file.getString("status_deja_on"));
		}
		if(file.contains("compte_a_rebour_pas_commencee") && file.get("compte_a_rebour_pas_commencee") != null){
			Msg.compte_a_rebour_pas_commencee.replaceBy(file.getString("compte_a_rebour_pas_commencee"));
		}
		if(file.contains("dans_aucune_arene") && file.get("dans_aucune_arene") != null){
			Msg.dans_aucune_arene.replaceBy(file.getString("dans_aucune_arene"));
		}
		if(file.contains("arene_reload") && file.get("arene_reload") != null){
			Msg.arene_reload.replaceBy(file.getString("arene_reload"));
		}
		if(file.contains("no_reload_avec_joueur") && file.get("no_reload_avec_joueur") != null){
			Msg.no_reload_avec_joueur.replaceBy(file.getString("no_reload_avec_joueur"));
		}
		if(file.contains("aucune_arene_config") && file.get("aucune_arene_config") != null){
			Msg.aucune_arene_config.replaceBy(file.getString("aucune_arene_config"));
		}
		if(file.contains("trop_arene") && file.get("trop_arene") != null){
			Msg.trop_arene.replaceBy(file.getString("trop_arene"));
		}
		if(file.contains("saut_rater") && file.get("saut_rater") != null){
			Msg.saut_rater.replaceBy(file.getString("saut_rater"));
		}
		if(file.contains("reussi_dac") && file.get("reussi_dac") != null){
			Msg.reussi_dac.replaceBy(file.getString("reussi_dac"));
		}
		if(file.contains("reussi_saut") && file.get("reussi_saut") != null){
			Msg.reussi_saut.replaceBy(file.getString("reussi_saut"));
		}
		if(file.contains("leave_win") && file.get("leave_win") != null){
			Msg.leave_win.replaceBy(file.getString("leave_win"));
		}
		if(file.contains("join") && file.get("join") != null){
			Msg.join.replaceBy(file.getString("join"));
		}
		if(file.contains("party_full") && file.get("party_full") != null){
			Msg.party_full.replaceBy(file.getString("party_full"));
		}
		if(file.contains("party_deja_en_cour") && file.get("party_deja_en_cour") != null){
			Msg.party_deja_en_cour.replaceBy(file.getString("party_deja_en_cour"));
		}
		if(file.contains("deja_dans_une_arene") && file.get("deja_dans_une_arene") != null){
			Msg.deja_dans_une_arene.replaceBy(file.getString("deja_dans_une_arene"));
		}
		if(file.contains("stop_Lobby_Timer") && file.get("stop_Lobby_Timer") != null){
			Msg.stop_Lobby_Timer.replaceBy(file.getString("stop_Lobby_Timer"));
		}
		if(file.contains("start_lobby_timer") && file.get("start_lobby_timer") != null){
			Msg.start_lobby_timer.replaceBy(file.getString("start_lobby_timer"));
		}
		if(file.contains("seconde") && file.get("seconde") != null){
			Msg.seconde.replaceBy(file.getString("seconde"));
		}
		if(file.contains("start_game") && file.get("start_game") != null){
			Msg.start_game.replaceBy(file.getString("start_game"));
		}
		if(file.contains("win") && file.get("win") != null){
			Msg.win.replaceBy(file.getString("win"));
		}
		if(file.contains("win_title") && file.get("win_title") != null){
			Msg.win_title.replaceBy(file.getString("win_title"));
		}
		if(file.contains("egalite") && file.get("egalite") != null){
			Msg.egalite.replaceBy(file.getString("egalite"));
		}
		if(file.contains("pas_confirmer") && file.get("pas_confirmer") != null){
			Msg.pas_confirmer.replaceBy(file.getString("pas_confirmer"));
		}
		if(file.contains("doit_confirmer") && file.get("doit_confirmer") != null){
			Msg.doit_confirmer.replaceBy(file.getString("doit_confirmer"));
		}
		if(file.contains("plusieurs_gagnants") && file.get("plusieurs_gagnants") != null){
			Msg.plusieurs_gagnants.replaceBy(file.getString("plusieurs_gagnants"));
		}
		if(file.contains("tour") && file.get("tour") != null){
			Msg.tour.replaceBy(file.getString("tour"));
		}
		if(file.contains("temps_restant") && file.get("temps_restant") != null){
			Msg.temps_restant.replaceBy(file.getString("temps_restant"));
		}
		if(file.contains("trop_attendu") && file.get("trop_attendu") != null){
			Msg.trop_attendu.replaceBy(file.getString("trop_attendu"));
		}
		if(file.contains("pannel_action") && file.get("pannel_action") != null){
			Msg.pannel_action.replaceBy(file.getString("pannel_action"));
		}
		if(file.contains("leave") && file.get("leave") != null){
			Msg.leave.replaceBy(file.getString("leave"));
		}
	}
}
