require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for Multi-Core BU devices"

COMPATIBLE_MACHINE = "keystone"

PR = "r6"
PV_append = "+git${SRCPV}"

# Tag "K2_UBOOT_2013_01_15.07_01"
SRCREV = "5eaedcc4c2bca0ed971ee46694df7edc0cfa36cf"
BRANCH = "master"

SRC_URI = "git://git.ti.com/keystone-linux/u-boot.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

UBOOT_SUFFIX = "bin"
UBOOT_MAKE_TARGET = "u-boot-spi.gph u-boot-nand.gph"

# SPI NOR Flash binaries
UBOOT_SPI_SPL_BINARY = "u-boot-spl.bin"
UBOOT_SPI_BINARY = "u-boot.img"
UBOOT_SPI_GPH_BINARY = "u-boot-spi.gph"
UBOOT_NAND_GPH_BINARY = "u-boot-nand.gph"

# SPI NOR Flash deployed images
UBOOT_SPI_SPL_IMAGE = "u-boot-spl-${MACHINE}-${PV}-${PR}.bin"
UBOOT_SPI_SPL_SYMLINK = "u-boot-spl-${MACHINE}.bin"
UBOOT_SPI_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.img"
UBOOT_SPI_SYMLINK = "u-boot-${MACHINE}.img"
UBOOT_SPI_GPH_IMAGE = "u-boot-spi-${MACHINE}-${PV}-${PR}.gph"
UBOOT_SPI_GPH_SYMLINK = "u-boot-spi-${MACHINE}.gph"
UBOOT_NAND_GPH_IMAGE = "u-boot-nand-${MACHINE}-${PV}-${PR}.gph"
UBOOT_NAND_GPH_SYMLINK = "u-boot-nand-${MACHINE}.gph"

do_install_append () {
	install ${S}/spl/${UBOOT_SPI_SPL_BINARY} ${D}/boot/${UBOOT_SPI_SPL_IMAGE}
	ln -sf ${UBOOT_SPI_SPL_IMAGE} ${D}/boot/${UBOOT_SPI_SPL_BINARY}

	install ${S}/${UBOOT_SPI_BINARY} ${D}/boot/${UBOOT_SPI_IMAGE}
	ln -sf ${UBOOT_SPI_IMAGE} ${D}/boot/${UBOOT_SPI_BINARY}

	install ${S}/${UBOOT_SPI_GPH_BINARY} ${D}/boot/${UBOOT_SPI_GPH_IMAGE}
	ln -sf ${UBOOT_SPI_GPH_IMAGE} ${D}/boot/${UBOOT_SPI_GPH_BINARY}

        install ${S}/${UBOOT_NAND_GPH_BINARY} ${D}/boot/${UBOOT_NAND_GPH_IMAGE}
        ln -sf ${UBOOT_NAND_GPH_IMAGE} ${D}/boot/${UBOOT_NAND_GPH_BINARY}
}

do_deploy_append () {
	install ${S}/spl/${UBOOT_SPI_SPL_BINARY} ${DEPLOYDIR}/${UBOOT_SPI_SPL_IMAGE}
	rm -f ${UBOOT_SPI_SPL_BINARY} ${UBOOT_SPI_SPL_SYMLINK}
	ln -sf ${UBOOT_SPI_SPL_IMAGE} ${UBOOT_SPI_SPL_SYMLINK}
	ln -sf ${UBOOT_SPI_SPL_IMAGE} ${UBOOT_SPI_SPL_BINARY}

	install ${S}/${UBOOT_SPI_BINARY} ${DEPLOYDIR}/${UBOOT_SPI_IMAGE}
	rm -f ${UBOOT_SPI_BINARY} ${UBOOT_SPI_SYMLINK}
	ln -sf ${UBOOT_SPI_IMAGE} ${UBOOT_SPI_SYMLINK}
	ln -sf ${UBOOT_SPI_IMAGE} ${UBOOT_SPI_BINARY}

	install ${S}/${UBOOT_SPI_GPH_BINARY} ${DEPLOYDIR}/${UBOOT_SPI_GPH_IMAGE}
	rm -f ${UBOOT_SPI_GPH_BINARY} ${UBOOT_SPI_GPH_SYMLINK}
	ln -sf ${UBOOT_SPI_GPH_IMAGE} ${UBOOT_SPI_GPH_SYMLINK}
	ln -sf ${UBOOT_SPI_GPH_IMAGE} ${UBOOT_SPI_GPH_BINARY}

        install ${S}/${UBOOT_NAND_GPH_BINARY} ${DEPLOYDIR}/${UBOOT_NAND_GPH_IMAGE}
        rm -f ${UBOOT_NAND_GPH_BINARY} ${UBOOT_NAND_GPH_SYMLINK}
        ln -sf ${UBOOT_NAND_GPH_IMAGE} ${UBOOT_NAND_GPH_SYMLINK}
        ln -sf ${UBOOT_NAND_GPH_IMAGE} ${UBOOT_NAND_GPH_BINARY}
}
