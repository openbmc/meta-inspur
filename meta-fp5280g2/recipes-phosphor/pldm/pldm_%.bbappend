FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

EXTRA_OEMESON_append = " \
        -Doem-ibm=enabled \
        "

SRC_URI += "file://fileTable.json"
SRC_URI += "file://enum_attrs.json"
SRC_URI += "file://effecter_pdr.json"
SRC_URI += "file://FRU_Master.json"
SRC_URI += "file://host_eid"

do_install_append() {
        install -d ${D}${datadir}/pldm/bios/
        install -d ${D}${datadir}/pldm/pdr/
        install -d ${D}${datadir}/pldm/fru/
        install -m 0644 ${WORKDIR}/fileTable.json ${D}${datadir}/pldm/
        install -m 0644 ${WORKDIR}/enum_attrs.json ${D}${datadir}/pldm/bios/
        install -m 0644 ${WORKDIR}/effecter_pdr.json ${D}${datadir}/pldm/pdr/
        install -m 0644 ${WORKDIR}/FRU_Master.json ${D}${datadir}/pldm/fru/
        install -m 0644 ${WORKDIR}/host_eid ${D}${datadir}/pldm/
}
