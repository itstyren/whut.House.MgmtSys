import Mock from 'mockjs'

const List = []
const count = 3


for (let i = 0; i < count; i++) {
  List.push(
    Mock.mock({
      region: '@county',
      address: '@csentence',
      struct: '@cword(4)',
      layout: '@cword(4)',
      houseRel: '@cword(2)'
    })
  )
}

export const getHouseList = config => {
  return List
}
