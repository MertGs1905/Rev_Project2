import { IUser } from './User';

export interface IPost {
    user: IUser;
    post: string;
    ratings: IRating;
}
