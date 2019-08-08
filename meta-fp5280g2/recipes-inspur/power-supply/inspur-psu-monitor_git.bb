SUMMARY = "Inspur Power supply monitor"
DESCRIPTION = "Power supply monitor for fp5280g2"
PR = "r1"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${INSPURBASE}/COPYING.apache-2.0;md5=34400b68072d710fecd0a2940a0d1658"

inherit autotools
inherit pkgconfig
inherit obmc-phosphor-systemd

S = "${WORKDIR}/git"

RDEPENDS_${PN} += "virtual/obmc-gpio-monitor"

SRC_URI += "git://github.com/inspur-bmc/inspur-psu-monitor.git"
PV = "1.0+git${SRCPV}"
SRCREV = "5ccf4cc8f1b247b55bdbe30a8e9a0f8a114d5977"

DEPENDS += " \
         phosphor-logging \
         autoconf-archive-native \
         "

INSPUR_PSU_MONITOR_TMPL = "inspur-psu-monitor@.service"
INSPUR_PSU_MONITOR_INSTFMT = "inspur-psu-monitor@{0}.service"
INSPUR_PSU_MONITOR_TGT = "multi-user.target" 
INSPUR_PSU_MONITOR_FMT = "../${INSPUR_PSU_MONITOR_TMPL}:${INSPUR_PSU_MONITOR_TGT}.requires/${INSPUR_PSU_MONITOR_INSTFMT}"

SYSTEMD_SERVICE_${PN} += "${INSPUR_PSU_MONITOR_TMPL}"
SYSTEMD_LINK_${PN} += "${@compose_list(d, 'INSPUR_PSU_MONITOR_FMT', 'OBMC_POWER_SUPPLY_INSTANCES')}"

INSPUR_PSU_MONITOR_ENV_FMT = "obmc/power-supply-monitor/power-supply-monitor-{0}.conf"
SYSTEMD_ENVIRONMENT_FILE_${PN} += "${@compose_list(d, 'INSPUR_PSU_MONITOR_ENV_FMT', 'OBMC_POWER_SUPPLY_INSTANCES')}"
