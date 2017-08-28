package com.trafalcraft.dac.texte;

public enum Msg {
	Prefix("§3§lDAC> §b"),
	No_Permission("vous n'avez pas le droit d'utiliser cette commande"),
	Commande_Imcomplete("la commande est imcomplète"),
	Argument_Incorect("argument #arg incorect"),
	Arene_Inexistante("cette arène n'existe pas ou est mal configurée"),
	No_Configure_Ingame("vous ne pouvez faire cela sur une arène en cours"),
	No_config_ingame_2("vous ne pouvez faire cela pendant une game"),
	arene_creee("arène crée"),
	arene_existante("cette arène existe déja"),
	lobby_config("le lobby a bien été enregistré"),
	plongeoir_config("le plongeoir a bien été enregistré"),
	lobby_event_config("le lobby d'event a bien été enregistré"),
	pos1_config("la pos 1 a bien été enregisté"),
	pos2_config("la pos 2 a bien été enregisté"),
	entrer_nombre("vous devez entrer un nombre"),
	config_mod("le mode de cette arène a bien été enregistré"),
	config_maxplayer("nombre de joueurs maximum enregistré"),
	config_maxpoint("nombre de points nécessaires pour gagner enregistré"),
	config_status("status enregistré"),
	status_off_mal_congig("impossible de set le status à on, l'arène est mal configurée"),
	status_deja_on("le status est déja à on"),
	compte_a_rebour_pas_commencee("le temps avant le lancement de la partie n'a pas encore commencé"),
	dans_aucune_arene("vous n'êtes dans aucune arène"),
	arene_reload("l'arène a bien été reload"),
	no_reload_avec_joueur("l'arène contient des joueurs en attente elle ne peut donc pas être reload"),
	aucune_arene_config("il n'y a aucune arène configurée"),
	trop_arene("il y a trop d'arènes configurées pour que le pannel d'administration les affiche"),
	saut_rater("#name a raté son saut"),
	reussi_dac("#name a réussi un dé à coudre"),
	reussi_saut("#name a réussi son saut"),
	leave_win("la partie est terminée, il n'y a plus assez de joueurs pour continuer"),
	join("#name a rejoint la partie"),
	party_full("la partie est déja pleine"),
	party_deja_en_cour("la partie est déja en cours"),
	deja_dans_une_arene("vous êtes déja dans une arène"),
	stop_Lobby_Timer("il n'y a plus assez de joueurs pour commencer la partie"),
	start_lobby_timer("la partie commence dans #temps seconde(s)"),
	seconde("seconde(s)"),
	start_game("la partie commence !!!"),
	win("#name a gagné la partie félicitation!!!"),
	win_title("a gagné"),
	egalite("égalité"),
	pas_confirmer("il n'a donc pas réussi à confirmer"),
	doit_confirmer("#name doit donc confirmer"),
	plusieurs_gagnants("les gagnants sont :"),
	tour("c est le tour de: #name"),
	temps_restant("il vous reste #temps seconde(s) pour sauter"),
	trop_attendu("#name a trop attendu pour sauter"),
	pannel_action("cette arène n'est pas en jeu vous ne pouvez donc pas y faire d'action"),
	leave("#name a quitté la partie")
	;
	 private String value;
	 
	private Msg(String value) {
		this.value = value;
    }
	
    public String toString(){
    	return value;
    }
    
    public void replaceby(String value){
		this.value = value;
    }
    
    public void replaceBy(String s){
    	this.value = s;
    }
}
