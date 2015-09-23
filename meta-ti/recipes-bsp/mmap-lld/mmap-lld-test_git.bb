DESCRIPTION = "TI KEYSTONE MMAP driver test binaries "
include mmap-lld.inc

DEPENDS="common-csl-ip mmap-lld"
RDEPENDS_${PN}="uio-module-drv"

DEVICELIST = "k2h \
              k2k \
              k2e \
"

CHOICELIST = " yes \
               no \
"

do_compile () {
	for device in ${DEVICELIST}
	do
		make -f makefile_armv7 clean \
			PDK_INSTALL_PATH="${STAGING_INCDIR}" \
			DEVICE="$device" MPAX_SRC_DIR="${S}"
		for choice in ${CHOICELIST}
		do
			make -f makefile_armv7 tests examples \
				PDK_INSTALL_PATH=${STAGING_INCDIR} \
				DEVICE="$device" MPAX_SRC_DIR="${S}" \
				USEDYNAMIC_LIB="$choice"
		done
	done
}

do_install () {
	for device in ${DEVICELIST}
	do
		make -f makefile_armv7 installbin \
		PDK_INSTALL_PATH=${STAGING_INCDIR} \
		DEVICE="$device" MPAX_SRC_DIR="${S}" \
		INSTALL_BIN_BASE_DIR="${D}/${bindir}"
	done
}
