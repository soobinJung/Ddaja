// import Layout from '@/layout'

const questionRouter = {
  path: 'question',
  component: { render(c) { return c('router-view') } },
  redirect: '/admin/question',
  name: 'question',
  meta: {
    title: '문제 관리'
  },
  children: [
    {
      path: '/',
      component: () => import('@/views/admin/question'),
      props: (route) => ({ query: route.query.test }),
      name: '문제 관리 메인',
      meta: {
        title: '문제 관리 메인'
      },
      roles: ['admin']
    }
  ]
}
export default questionRouter
