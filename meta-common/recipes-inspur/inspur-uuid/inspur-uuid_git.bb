SUMMARY = "Inspur Identify LED Controller daemon"
DESCRIPTION = "Daemon to trigger actions on a inspur identify LED"

PR = "r1"
PV = "1.0+git${SRCPV}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

inherit autotools pkgconfig
inherit obmc-phosphor-systemd

DEPENDS += "autoconf-archive-native"
DEPENDS += "sdbusplus"
DEPENDS += "sdeventplus"
DEPENDS += "phosphor-dbus-interfaces"
DEPENDS += "phosphor-logging"
DEPENDS += "gpioplus"

RDEPENDS_${PN} += "libsystemd"

SYSTEMD_SERVICE_${PN} += "xyz.openbmc_project.inspur.identify_led.controller.service"

SRC_URI = "git://github.com/wangzqbj/inspur-uuid.git"

PV = "1.0+git${SRCPV}"
SRCREV = "c6ff1517548e355e85aadf8d35b7904ad536cc27"

S = "${WORKDIR}/git"
