import request from '@/utils/request'

export function fetchList(param) {
    return request({
        url    : '/round',
        method : 'get',
        params : {
            licenseID : param.licenseID || '',
            examYear  : param.examYear  || '',
            inUse     : true
        }
    })
}

export function licenseList(param) {
    return request({
        url    : '/licenses',
        method : 'get',
        params: {}
    })
}