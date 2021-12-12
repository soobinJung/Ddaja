import request from '@/utils/request'

export function getQuestion(param) {
    return request({
        url: '/question/' + param.id
        , method: 'get'
        , params: {}
    })
}