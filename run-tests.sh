#!/usr/bin/env bash

INPUT_FILES=("input-1.txt" "input-2.txt" "input-3.txt" "input-4.txt" "input-5.txt")
ALGORITHMS=("naive" "greedy" "dp")
EXPECTED_ANSWERS=(1472 672 284 438000 3630000 438000 3630000 3630000 438000 20375128344 7053967329 51646670 389013761244546 120855373598633 98296322558)

pushd src

for i in ${!INPUT_FILES[@]}; do
  for j in ${!ALGORITHMS[@]}; do
    COMMAND="java ${ALGORITHMS[j]} < ${INPUT_FILES[i]}"
    echo ${COMMAND}
    RESULT=$(eval ${COMMAND})
    EXPECTED_RESULT=${EXPECTED_ANSWERS[i*3+j]}

    if [[ "$RESULT" != "${EXPECTED_RESULT}" ]]; then
      echo "FAILED: ${ALGORITHMS[j]} ${INPUT_FILES[i]} - expected: ${EXPECTED_RESULT}, actual: $RESULT"
    else
      echo "PASSED"
    fi
  done
done

popd
