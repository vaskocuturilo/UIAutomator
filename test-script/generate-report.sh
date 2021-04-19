#!/bin/bash
set -x
set -u
set -e

# Check OS type
if [ "${OSTYPE//[0-9.]/}" == "darwin" ]; then
  export ANDROID_HOME="${HOME}/Library/Android/sdk"
  export PATH=${ANDROID_HOME}/emulator:${ANDROID_HOME}/tools:$PATH

elif [ "${OSTYPE//[0-9.]/}" == "linux-gnu" ]; then
  export ANDROID_HOME="${HOME}/Android/Sdk"
  export PATH=${ANDROID_HOME}/emulator:${ANDROID_HOME}/tools:$PATH

elif [ "${OSTYPE//[0-9.]/}" == "win32" ]; then
  export ANDROID_HOME="${HOME}/Android/Sdk"

else
  printf "I don't know OS Type"
fi

ADB="${ANDROID_HOME}/platform-tools/adb"

function generate_report() {
  cd ..
  ${ADB} pull /sdcard/allure-results

  allure generate allure-results --clean -o allure-report

}

generate_report