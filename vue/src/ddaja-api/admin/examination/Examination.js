import request from '@/utils/request'

export function fetchRoundList(param) {
  return request({
    url: '/round',
    method: 'get',
    params: {
      licenseID: param.licenseID || 0,
      examYear: param.examYear || '',
      inUse: true
    }
  })
}

export function fetchQuestionList(param) {
  return request({
    url: '/question',
    method: 'get',
    params: {
      licenseID: param.licenseID || 0,
      roundID: param.roundID || 0,
      inUse: true
    }
  })
}

export function licenseList(param) {
  return request({
    url: '/licenses',
    method: 'get',
    params: {}
  })
}
