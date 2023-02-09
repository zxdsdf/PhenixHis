import request from '@/utils/request'

export function login(data) {
  return request({
    url: 'http://localhost:11111/system/admin/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: 'http://localhost:11111/system/admin/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: 'http://localhost:11111/system/admin/login',
    method: 'post'
  })
}
