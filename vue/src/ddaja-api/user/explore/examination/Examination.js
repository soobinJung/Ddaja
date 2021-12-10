import request from '@/utils/request'

export function fetchListByRounds(param) {
  return request({
    url: '/round',
    method: 'get',
    params: {
      licenseID: param.licenseID || '',
      examYear: param.examYear || '',
      inUse: true
    }
  })
}

export function fetchListByQuestions(param) {
  return request({
    url: '/question',
    method: 'get',
    params: {
      licenseID : param.licenseID || 0,
      roundID   : param.roundID   || 0,
      SubjectID : param.SubjectID || 0,
      inUse: true
    }
  })
}

// answerFive: "답5"
// answerFour: "답4"
// answerOne: "답1"
// answerThr: "답3"
// answerTwo: "답2"
// content: "립스틱"
// created: false
// createdDate: 1638653871000
// id: 9
// inUse: true
// isCreated: false
// lid: 1
// no: 1
// rid: 17
// score: 3
// sid: 2
// title: "랄라블라"