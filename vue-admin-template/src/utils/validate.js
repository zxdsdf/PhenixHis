/**
 * Created by PanJiaChen on 16/11/18.
 */

/**
 * @param {string} path
 * @returns {Boolean}
 */
export function isExternal(path) {
  return /^(https?:|mailto:|tel:)/.test(path)
}

/**
 * @param {string} str
 * @returns {Boolean}
 */
export function validUsername(str) {
  const valid_map = ['admin', 'editor']
  return valid_map.indexOf(str.trim()) >= 0
}

/**
 * <b>对手机号码进行有效性检验</b>
 * @param str
 */
export function validCellphone(str) {
  const regex = /^1[0-9]{10}$/
  return regex.test(str)
}

export function validPassword(str) {
  const regex = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,15}$/
  return regex.test(str)
}
