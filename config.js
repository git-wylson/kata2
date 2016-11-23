"use strict";
angular.module("utilsMdl")
  .factory('config', ['DEBUG_MODE', function (DEBUG_MODE) {
    return {
      // messages à internationaliser
      msgWaitingInit: "msg_waiting_init",
      msgWaiting: "msg_waiting",
      loadingError: 'loading_error',
      canceledOperation: 'canceled_operation',
     
      /*------------------
       - URLS DU CLIENTS -
       -------------------*/
      urlLogin: "/login",
      
      // Accueil
      menuAccueil: { uri: "/accueil", name: "accueil", title: "menu.accueil.title", icon: "fa fa-home" },

      // Administration
      menuAdministration: { uri: "/administration", name: "administration", title: "menu.administration.title", icon: "fa fa-hospital-o" },

      // Ambulatoire
      menuAmbulatoire: { uri: "/ambulatoire", name: "ambulatoire", title: "menu.ambulatoire.title", icon: "fa fa-ambulance" },
      menuAmbuMedicochiru: { uri: "/ambulatoire/medicochiru", name: "ambulatoire.medicochiru", title: "menu.ambu.medicochiru.title", icon: "" },
      menuAmbuMedicochiruPlainte: { uri: "/ambulatoire/medicochiru/plainte", name: "ambulatoire.medicochiru.plainte", title: "menu.ambu.medicochiru.pliante.title", icon: "" },
      menuAmbuMedicochiruExamen: { uri: "/ambulatoire/medicochiru/examen", name: "ambulatoire.medicochiru.examen", title: "menu.ambu.medicochiru.examen.title", icon: "" },
      menuAmbuMedicochiruAvismedico: { uri: "/ambulatoire/medicochiru/avismedicaux", name: "ambulatoire.medicochiru.avismedicaux", title: "menu.ambu.medicochiru.avismedicaux.title", icon: "" },

      // Hospitalisation
      menuHospitalisation: { uri: "/hospitalisation", name: "hospitalisation", title: "menu.hospitalisation.title", icon: "fa fa-h-square" },

      // Comptabilité
      menuComptabilite: { uri: "/comptabilite", name: "comptabilite", title: "menu.comptabilite.title", icon: "fa fa-money" },

      // Documents
      menuDocuments: { uri: "/documents", name: "documents", title: "menu.documents.title", icon: "fa fa-folder-open-o" },

      // Mailbox 
      menuMailbox: { uri: "/mailbox", name: "mailbox", title: "menu.mailbox.title", icon: "fa fa-envelope" },

      // Prise rendez vous
      menuPriserendezvous: { uri: "/priserdv", name: "priserdv", title: "menu.priserdv.title", icon: "fa fa-calendar" },

      // Rendez vous du jour
      menuRendezvousjour: { uri: "/rdvjour", name: "rdvjour", title: "menu.rdvjour.title", icon: "fa fa-circle-o text-yellow" },

      // Rendez vous de l'annee
      menuRendezvousannee: { uri: "/rdvannee", name: "rdvannee", title: "menu.rdvannee.title", icon: "fa fa-circle-o text-aqua" },

      /*------------------
       - URLS DU SERVEUR -
       -------------------*/
      urlSvrRendezvousjour: "/getAllMedecins",
      

      // délai d'attente maximal pour les appels http en millisecondes
      timeout: 1000,
      // temps d'attente avant une tâche 
      waitingTimeBeforeTask: 3000,
      // mode debug
      debug: DEBUG_MODE, // Cette variable est defini dans app.mdl.js
      // les deux locales utilisées
      locales: {
        fr: {
          "DATETIME_FORMATS": {
            "AMPMS": [
              "AM",
              "PM"
            ],
            "DAY": [
              "dimanche",
              "lundi",
              "mardi",
              "mercredi",
              "jeudi",
              "vendredi",
              "samedi"
            ],
            "MONTH": [
              "janvier",
              "f\u00e9vrier",
              "mars",
              "avril",
              "mai",
              "juin",
              "juillet",
              "ao\u00fbt",
              "septembre",
              "octobre",
              "Noovembre",
              "d\u00e9cembre"
            ],
            "SHORTDAY": [
              "dim.",
              "lun.",
              "mar.",
              "mer.",
              "jeu.",
              "ven.",
              "sam."
            ],
            "SHORTMONTH": [
              "janv.",
              "f\u00e9vr.",
              "mars",
              "avr.",
              "mai",
              "juin",
              "juil.",
              "ao\u00fbt",
              "sept.",
              "oct.",
              "nov.",
              "d\u00e9c."
            ],
            "fullDate": "EEEE d MMMM y",
            "longDate": "d MMMM y",
            "medium": "d MMM y HH:mm:ss",
            "mediumDate": "d MMM y",
            "mediumTime": "HH:mm:ss",
            "short": "dd/MM/yy HH:mm",
            "shortDate": "dd/MM/yy",
            "shortTime": "HH:mm"
          },
          "NUMBER_FORMATS": {
            "CURRENCY_SYM": "\u20ac",
            "DECIMAL_SEP": ",",
            "GROUP_SEP": "\u00a0",
            "PATTERNS": [
              {
                "gSize": 3,
                "lgSize": 3,
                "macFrac": 0,
                "maxFrac": 3,
                "minFrac": 0,
                "minInt": 1,
                "negPre": "-",
                "negSuf": "",
                "posPre": "",
                "posSuf": ""
              },
              {
                "gSize": 3,
                "lgSize": 3,
                "macFrac": 0,
                "maxFrac": 2,
                "minFrac": 2,
                "minInt": 1,
                "negPre": "(",
                "negSuf": "\u00a0\u00a4)",
                "posPre": "",
                "posSuf": "\u00a0\u00a4"
              }
            ]
          },
          "id": "fr-fr",
          "pluralCat": function (n) {
            if (n >= 0 && n <= 2 && n != 2) {
              return PLURAL_CATEGORY.ONE;
            }
            return PLURAL_CATEGORY.OTHER;
          }
        },
        en: {
          "DATETIME_FORMATS": {
            "AMPMS": [
              "AM",
              "PM"
            ],
            "DAY": [
              "Sunday",
              "Monday",
              "Tuesday",
              "Wednesday",
              "Thursday",
              "Friday",
              "Saturday"
            ],
            "MONTH": [
              "January",
              "February",
              "March",
              "April",
              "May",
              "June",
              "July",
              "August",
              "September",
              "October",
              "November",
              "December"
            ],
            "SHORTDAY": [
              "Sun",
              "Mon",
              "Tue",
              "Wed",
              "Thu",
              "Fri",
              "Sat"
            ],
            "SHORTMONTH": [
              "Jan",
              "Feb",
              "Mar",
              "Apr",
              "May",
              "Jun",
              "Jul",
              "Aug",
              "Sep",
              "Oct",
              "Nov",
              "Dec"
            ],
            "fullDate": "EEEE, MMMM d, y",
            "longDate": "MMMM d, y",
            "medium": "MMM d, y h:mm:ss a",
            "mediumDate": "MMM d, y",
            "mediumTime": "h:mm:ss a",
            "short": "M/d/yy h:mm a",
            "shortDate": "M/d/yy",
            "shortTime": "h:mm a"
          },
          "NUMBER_FORMATS": {
            "CURRENCY_SYM": "$",
            "DECIMAL_SEP": ".",
            "GROUP_SEP": ",",
            "PATTERNS": [
              {
                "gSize": 3,
                "lgSize": 3,
                "macFrac": 0,
                "maxFrac": 3,
                "minFrac": 0,
                "minInt": 1,
                "negPre": "-",
                "negSuf": "",
                "posPre": "",
                "posSuf": ""
              },
              {
                "gSize": 3,
                "lgSize": 3,
                "macFrac": 0,
                "maxFrac": 2,
                "minFrac": 2,
                "minInt": 1,
                "negPre": "(\u00a4",
                "negSuf": ")",
                "posPre": "\u00a4",
                "posSuf": ""
              }
            ]
          },
          "id": "en-us",
          "pluralCat": function (n) {
            if (n == 1) {
              return PLURAL_CATEGORY.ONE;
            }
            return PLURAL_CATEGORY.OTHER;
          }
        }
      }
    };
  }]);
